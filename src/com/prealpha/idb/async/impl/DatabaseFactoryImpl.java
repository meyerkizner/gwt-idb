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

package com.prealpha.idb.async.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.prealpha.idb.async.Database;
import com.prealpha.idb.async.DatabaseFactory;

/**
 * A default implementation of {@link DatabaseFactory}. A native
 * {@code IDBFactory} is used as the peer for this implementation. There is a
 * default mechanism in place for obtaining a reference to a peer, but this
 * behavior can be redefined by overriding the protected method
 * {@link #getPeer()} in a subclass.
 * 
 * @author Meyer Kizner
 * 
 */
class DatabaseFactoryImpl implements DatabaseFactory {
	/**
	 * Constructs a new {@code DatabaseFactoryImpl}.
	 */
	public DatabaseFactoryImpl() {
	}

	@Override
	public final native void getDatabase(String name,
			AsyncCallback<Database> callback) /*-{
		var peer = this.@com.prealpha.idb.async.impl.DatabaseFactoryImpl::getPeer()();
		var request = peer.open(name, callback);
		@com.prealpha.idb.async.impl.DatabaseFactoryImpl::handleRequest(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/user/client/rpc/AsyncCallback;)(request, callback);
	}-*/;

	@Override
	public final native void deleteDatabase(String name,
			AsyncCallback<Void> callback) /*-{
		var peer = this.@com.prealpha.idb.async.impl.DatabaseFactoryImpl::getPeer()();
		var request = peer.deleteDatabase(name, callback);
		@com.prealpha.idb.async.impl.DatabaseFactoryImpl::handleRequest(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/user/client/rpc/AsyncCallback;)(request, callback);
	}-*/;

	/**
	 * Returns the native peer of this database factory. The native peer must be
	 * of the type {@code IDBFactory} as defined in the spec (2011-04-19).
	 * <p>
	 * 
	 * The default implementation of this method checks to see if the
	 * {@code window.indexedDB} property is defined. If the property is defined,
	 * it is returned; otherwise, {@link UnsupportedOperationException} is
	 * thrown to indicate the lack of browser support.
	 * 
	 * @return the native peer
	 * @throws UnsupportedOperationException
	 *             if the browser does not support IndexedDB
	 */
	protected native JavaScriptObject getPeer() /*-{
		if ($wnd.indexedDB) {
			return $wnd.indexedDB;
		} else {
			throw @java.lang.UnsupportedOperationException::new(Ljava/lang/String;)("this browser does not support IndexedDB");
		}
	}-*/;

	/**
	 * Attaches the callback to the native {@code IDBRequest}. In the native
	 * API, request objects implement the JavaScript idiom for asynchronous
	 * calls. This method attaches callbacks to the native request to forward
	 * the result or error code to the Java callback.
	 * 
	 * @param request
	 *            the native {@code IDBRequest} to handle
	 * @param callback
	 *            the callback which receives the result of the native request
	 */
	private static native void handleRequest(JavaScriptObject request,
			AsyncCallback<?> callback) /*-{
		request.onsuccess = function(event) {
			callback.@com.google.gwt.user.client.rpc.AsyncCallback::onSuccess(Ljava/lang/Object;)(request.result);
		};
		request.onerror = function(event) {
			var type = @com.prealpha.idb.shared.IndexedDbException.Type::getType(I)(request.errorCode);
			var exception = @com.prealpha.idb.shared.IndexedDbException::new(Lcom/prealpha/idb/shared/IndexedDbException$Type;)(type);
			callback.@com.google.gwt.user.client.rpc.AsyncCallback::onFailure(Ljava/lang/Throwable;)(exception);
		};
	}-*/;
}
