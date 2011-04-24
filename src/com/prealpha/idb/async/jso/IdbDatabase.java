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

public final class IdbDatabase extends JavaScriptObject {
	protected IdbDatabase() {
	}

	public native String name() /*-{
		return this.name;
	}-*/;

	public native String version() /*-{
		return this.version;
	}-*/;

	public native DomStringList objectStoreNames() /*-{
		return this.objectStoreNames;
	}-*/;

	public native IdbObjectStore createObjectStore(String name, String keyPath,
			boolean autoIncrement) throws IndexedDbException /*-{
		try {
			var optionalParameters = {};
			optionalParameters.keyPath = keyPath;
			optionalParameters.autoIncrement = autoIncrement;
			return this.createObjectStore(name, optionalParameters);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest deleteObjectStore(String name)
			throws IndexedDbException /*-{
		try {
			return this.deleteObjectStore(name);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbVersionChangeRequest setVersion(String version) /*-{
		return this.setVersion(version);
	}-*/;

	public native IdbTransaction transaction(DomStringList storeNames, int mode)
			throws IndexedDbException /*-{
		try {
			return this.transaction(storeNames, mode);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native void close() /*-{
		this.close();
	}-*/;

	public native void onabort(Callback callback) /*-{
		this.onabort = function(event) {
			callback.@com.prealpha.idb.async.jso.Callback::run(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
		};
	}-*/;

	public native void onerror(Callback callback) /*-{
		this.onerror = function(event) {
			callback.@com.prealpha.idb.async.jso.Callback::run(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
		};
	}-*/;

	public native void onversionchange(Callback callback) /*-{
		this.onversionchange = function(event) {
			callback.@com.prealpha.idb.async.jso.Callback::run(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
		};
	}-*/;
}
