/*
 * gwt-idb, IndexedDB for GWT
 * Copyright (C) 2011 Meyer Kizner
 * 
 * This file is part of gwt-idb.
 * 
 * gwt-idb is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * gwt-idb is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with gwt-idb. If not, see <http://www.gnu.org/licenses/>.
 */

package com.prealpha.idb.shared;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Exceptions which result from the use of the IndexedDB API. The spec
 * (2011-04-19) defines eleven conditions which can result in this exception
 * being thrown.
 * 
 * @author Meyer Kizner
 * 
 */
public class IndexedDbException extends Exception {
	/**
	 * The exception types which can occur. These are defined in the same order
	 * as in the spec (2011-04-19), so that the error code corresponding to each
	 * constant is {@code ordinal() + 1}. The doc comments for each constant are
	 * exactly the descriptions given in the spec.
	 * 
	 * @author Meyer Kizner
	 * 
	 */
	public static enum Type {
		/**
		 * The operation failed for reasons unrelated to the database itself and
		 * not covered by any other error code.
		 */
		UNKNOWN,

		/**
		 * This error occurred because an operation was not allowed on an
		 * object. A retry of the same operation would fail unless the cause of
		 * the error is corrected.
		 */
		NOT_TRANSIENT,

		/**
		 * The operation failed because the requested database object could not
		 * be found. For example, an object store did not exist but was being
		 * opened.
		 */
		NOT_FOUND,

		/**
		 * A mutation operation in the transaction failed due to a because a
		 * constraint was not satisfied. For example, an object such as an
		 * object store or index already exists and a new one was being
		 * attempted to be created.
		 */
		CONSTRAINT,

		/**
		 * Data provided to an operation does not meet requirements.
		 */
		DATA,

		/**
		 * A operation called on an object on which it is not allowed or at a
		 * time when it is not allowed. The {@link #TRANSACTION_INACTIVE} and
		 * {@link #READ_ONLY} errors are more specific variants of this error.
		 */
		NOT_ALLOWED,

		/**
		 * A request was placed against a transaction which is currently not
		 * active, or which is finished.
		 */
		TRANSACTION_INACTIVE,

		/**
		 * A request was aborted, for example through a call to
		 * {@code Transaction.abort()}.
		 */
		ABORT,

		/**
		 * The mutating operation was attempted in a {@code READ_ONLY}
		 * transaction.
		 */
		READ_ONLY,

		/**
		 * A lock for the transaction could not be obtained in a reasonable
		 * time.
		 */
		TIMEOUT,

		/**
		 * The operation failed because there was not enough remaining storage
		 * space, or the storage quota was reached and the user declined to give
		 * more space to the database.
		 */
		QUOTA;

		/**
		 * Returns the {@code Type} associated with the given native error code.
		 * 
		 * @param errorCode
		 *            the native error code
		 * @return the corresponding {@code Type}
		 */
		public static Type getType(int errorCode) {
			try {
				return values()[errorCode - 1];
			} catch (IndexOutOfBoundsException ioobx) {
				throw new IllegalArgumentException("invalid error code");
			}
		}
	}

	/**
	 * Handles a native exception by either converting it to an
	 * {@code IndexedDbException} or re-throwing it. If the exception is a
	 * native {@code IDBDatabaseException}, its error code is converted to a
	 * {@link Type} and the resulting {@code IndexedDbException} is thrown.
	 * Otherwise, the native exception is thrown into the calling code. In the
	 * latter case, the GWT compiler will convert it into a
	 * {@link JavaScriptException}.
	 * <p>
	 * 
	 * This method is registered as a global function in JavaScript by a static
	 * initializer. It is accessible as {@code window.handleIdbx}.
	 * 
	 * @param err
	 *            the native exception
	 * @throws IndexedDbException
	 *             if the native exception is an {@code IDBDatabaseException},
	 *             the converted form
	 * @throws JavaScriptException
	 *             if the native exception is not a {@code IDBDatabaseException}
	 *             , the original exception
	 */
	private static native void handleIdbx(JavaScriptObject err)
			throws IndexedDbException /*-{
		if (err instanceof IdbDatabaseException) {
			var errorCode = err.code;
			var type = @com.prealpha.idb.shared.IndexedDbException.Type::getType(I)(errorCode);
			var message = err.message;
			throw @com.prealpha.idb.shared.IndexedDbException::new(Lcom/prealpha/idb/shared/IndexedDbException$Type;Ljava/lang/String;)(type, message);
		} else {
			throw err;
		}
	}-*/;

	/**
	 * Exports {@link #handleIdbx(JavaScriptObject)} as a JavaScript global
	 * function. This method is called by a static initializer. It should not be
	 * accessed otherwise.
	 */
	private static native void exportHandleIdbx() /*-{
		$wnd.handleIdbx = $entry(@com.prealpha.idb.shared.IndexedDbException::handleIdbx(Lcom/google/gwt/core/client/JavaScriptObject;));
	}-*/;

	static {
		exportHandleIdbx();
	}

	/**
	 * The type of this exception, as determined by the native error code.
	 */
	private final Type type;

	/**
	 * Constructs a new {@code IndexedDbException} with the specified exception
	 * type, but no detail message. This constructor should be used when an
	 * asynchronous callback receives an error event but a full exception is not
	 * thrown.
	 * 
	 * @param type
	 *            the type of this exception
	 * @throws NullPointerException
	 *             if {@code type} is {@code null}
	 */
	public IndexedDbException(Type type) {
		this(type, null);
	}

	/**
	 * Constructs a new {@code IndexedDbException} with the specified exception
	 * type and detail message. This constructor should be used when a native
	 * {@code IDBDatabaseException} is thrown.
	 * 
	 * @param type
	 *            the type of this exception
	 * @param message
	 *            a detail message explaining the exception
	 * @throws NullPointerException
	 *             if {@code type} is {@code null}
	 */
	public IndexedDbException(Type type, String message) {
		super(message);
		if (type == null) {
			throw new NullPointerException();
		}
		this.type = type;
	}

	/**
	 * Returns the type of this exception. The type is determined by the native
	 * error code. All types are defined in the spec.
	 * 
	 * @return the type of this exception
	 */
	public Type getType() {
		return type;
	}
}
