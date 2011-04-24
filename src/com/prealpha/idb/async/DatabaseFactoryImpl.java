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
import com.prealpha.idb.async.jso.Callback;
import com.prealpha.idb.async.jso.IdbDatabase;
import com.prealpha.idb.async.jso.IdbFactory;
import com.prealpha.idb.async.jso.IdbRequest;
import com.prealpha.idb.shared.IndexedDbException;
import com.prealpha.idb.shared.IndexedDbException.Type;

/**
 * A default implementation of {@link DatabaseFactory}. This implementation uses
 * a {@link IdbFactory} peer to allow for cross-browser support. There is a
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
	public final void getDatabase(String name,
			final AsyncCallback<Database> callback) {
		final IdbRequest request = getPeer().open(name);
		request.onerror(new Callback() {
			@Override
			public void run(JavaScriptObject event) {
				int errorCode = request.errorCode();
				Type type = Type.getType(errorCode);
				callback.onFailure(new IndexedDbException(type));
			}
		});
		request.onsuccess(new Callback() {
			@Override
			public void run(JavaScriptObject event) {
				IdbDatabase database = (IdbDatabase) request.result();
				callback.onSuccess(new Database(database));
			}
		});
	}

	@Override
	public final void deleteDatabase(String name,
			final AsyncCallback<Void> callback) {
		final IdbRequest request = getPeer().deleteDatabase(name);
		request.onerror(new Callback() {
			@Override
			public void run(JavaScriptObject event) {
				int errorCode = request.errorCode();
				Type type = Type.getType(errorCode);
				callback.onFailure(new IndexedDbException(type));
			}
		});
		request.onsuccess(new Callback() {
			@Override
			public void run(JavaScriptObject event) {
				callback.onSuccess(null);
			}
		});
	}

	/**
	 * Returns the {@link IdbFactory} peer of this database factory.
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
	protected native IdbFactory getPeer() /*-{
		if ($wnd.indexedDB) {
			return $wnd.indexedDB;
		} else {
			throw @java.lang.UnsupportedOperationException::new(Ljava/lang/String;)("this browser does not support IndexedDB");
		}
	}-*/;
}
