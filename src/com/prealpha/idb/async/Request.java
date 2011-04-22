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

package com.prealpha.idb.async;

import static com.google.common.base.Preconditions.*;

import com.google.common.base.Function;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * A helper class which allows Java code to associate an {@link AsyncCallback}
 * with an {@code IDBRequest} peer. Only one callback may be associated with a
 * {@code Request} at a time.
 * 
 * @author Meyer Kizner
 * 
 */
final class Request {
	/**
	 * The native {@code IDBRequest} peer.
	 */
	private final JavaScriptObject peer;

	/**
	 * Constructs a new {@code Request} with the peer given. The peer must be
	 * non-{@code null}, and it must be a native {@code IDBRequest}.
	 * 
	 * @param peer
	 *            the native peer
	 * @throws NullPointerException
	 *             if {@code peer} is {@code null}
	 * @throws IllegalArgumentException
	 *             if {@code peer} is not a native {@code IDBRequest}
	 */
	Request(JavaScriptObject peer) {
		checkNotNull(peer);
		checkArgument(validatePeer(peer));
		this.peer = peer;
	}

	/**
	 * Attaches an {@link AsyncCallback} to this request. When the request
	 * results in success, {@code requestMapping} is used to convert the native
	 * result into a Java object suitable for return to {@code callback}. When
	 * the request results in failure, an {@link IndexedDbException} is
	 * constructed and returned to {@code callback}. Only one callback may be
	 * associated with a request peer at one time; invoking this method will
	 * remove any other Java callbacks from the native peer.
	 * 
	 * @param <T>
	 *            the Java type of this request's result
	 * @param callback
	 *            the callback which receives the result or exception
	 * @param resultMapping
	 *            converts the native result into a Java object for the callback
	 */
	native <T> void attach(AsyncCallback<T> callback,
			Function<JavaScriptObject, T> resultMapping) /*-{
		var peer = this.@com.prealpha.idb.async.Request::peer;
		peer.onsuccess = function(event) {
			var nativeResult = peer.result;
			var result = resultMapping.@com.google.common.base.Function::apply(Ljava/lang/Object;)(nativeResult);
			callback.@com.google.gwt.user.client.rpc.AsyncCallback::onSuccess(Ljava/lang/Object;)(result);
		};
		peer.onerror = function(event) {
			var errorCode = peer.errorCode;
			var type = @com.prealpha.idb.shared.IndexedDbException.Type::getType(I)(errorCode);
			var exception = @com.prealpha.idb.shared.IndexedDbException::new(Lcom/prealpha/idb/shared/IndexedDbException$Type;)(type);
			callback.@com.google.gwt.user.client.rpc.AsyncCallback::onFailure(Ljava/lang/Throwable;)(exception);
		};
	}-*/;

	/**
	 * Checks that the native peer provided is of the correct type,
	 * {@code IDBRequest}.
	 * 
	 * @param peer
	 *            the native peer
	 * @return {@code true} if {@code peer} is a native {@code IDBRequest}
	 */
	private native boolean validatePeer(JavaScriptObject peer) /*-{
		return (peer instanceof IDBRequest);
	}-*/;
}
