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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.prealpha.idb.shared.IndexedDbException;

/**
 * Represents a native {@code IDBRequest} object. This class is intended for
 * internal use only. Its only method attaches an {@link AsyncCallback} to the
 * underlying native request.
 * 
 * @author Meyer Kizner
 * 
 */
final class Request extends JavaScriptObject {
	/**
	 * Not directly instantiable.
	 */
	protected Request() {
	}

	/**
	 * Attaches an {@link AsyncCallback} to this request. When the request
	 * results in success, the native result is returned to {@code callback}
	 * through the {@link AsyncCallback#onSuccess(Object) onSuccess} method.
	 * When the request results in failure, an {@link IndexedDbException} is
	 * constructed and returned to {@code callback} through
	 * {@link AsyncCallback#onFailure(Throwable) onFailure}. Only one callback
	 * may be associated with a request at one time; invoking this method will
	 * remove any other Java callbacks from this request.
	 * 
	 * @param callback
	 *            the callback which receives the result or exception
	 */
	native void attach(AsyncCallback<? extends JavaScriptObject> callback) /*-{
		this.onsuccess = function(event) {
			var result = this.result;
			callback.@com.google.gwt.user.client.rpc.AsyncCallback::onSuccess(Ljava/lang/Object;)(result);
		};
		this.onerror = function(event) {
			var errorCode = this.errorCode;
			var type = @com.prealpha.idb.shared.IndexedDbException.Type::getType(I)(errorCode);
			var exception = @com.prealpha.idb.shared.IndexedDbException::new(Lcom/prealpha/idb/shared/IndexedDbException$Type;)(type);
			callback.@com.google.gwt.user.client.rpc.AsyncCallback::onFailure(Ljava/lang/Throwable;)(exception);
		};
	}-*/;
}
