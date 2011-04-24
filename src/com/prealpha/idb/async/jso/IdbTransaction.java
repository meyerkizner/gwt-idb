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

package com.prealpha.idb.async.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.prealpha.idb.shared.IndexedDbException;

public final class IdbTransaction extends JavaScriptObject {
	protected IdbTransaction() {
	}

	public native int mode() /*-{
		return this.mode;
	}-*/;

	public native IdbDatabase database() /*-{
		return this.database;
	}-*/;

	public native IdbObjectStore objectStore(String name)
			throws IndexedDbException /*-{
		try {
			return this.objectStore(name);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native void abort() throws IndexedDbException /*-{
		try {
			this.abort();
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native void onabort(Callback callback) /*-{
		this.onabort = function(event) {
			callback.@com.prealpha.idb.async.jso.Callback::run(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
		};
	}-*/;

	public native void oncomplete(Callback callback) /*-{
		this.oncomplete = function(event) {
			callback.@com.prealpha.idb.async.jso.Callback::run(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
		};
	}-*/;

	public native void onerror(Callback callback) /*-{
		this.onerror = function(event) {
			callback.@com.prealpha.idb.async.jso.Callback::run(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
		};
	}-*/;
}
