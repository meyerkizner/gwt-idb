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

public final class IdbObjectStore extends JavaScriptObject {
	protected IdbObjectStore() {
	}

	public native String name() /*-{
		return this.name;
	}-*/;

	public native String keyPath() /*-{
		return this.keyPath;
	}-*/;

	public native DomStringList indexNames() /*-{
		return this.indexNames;
	}-*/;

	public native IdbTransaction transaction() /*-{
		return this.transaction;
	}-*/;

	public native IdbRequest put(Object value) /*-{
		return this.put(value);
	}-*/;

	public native IdbRequest put(Object value, Object key) /*-{
		return this.put(value, key);
	}-*/;

	public native IdbRequest add(Object value) /*-{
		return this.add(value);
	}-*/;

	public native IdbRequest add(Object value, Object key) /*-{
		return this.add(value, key);
	}-*/;

	public native IdbRequest delete(Object key) /*-{
		// TODO: hack to allow access
		this["delete"](key);
	}-*/;

	public native IdbRequest get(Object key) /*-{
		return this.get(key);
	}-*/;

	public native IdbRequest clear() /*-{
		return this.clear();
	}-*/;

	public native IdbRequest openCursor(IdbKeyRange range, int direction) /*-{
		return this.openCursor(range, direction);
	}-*/;

	public native IdbIndex createIndex(String name, String keyPath,
			boolean unique, boolean multirow) /*-{
		var optionalParameters = {};
		optionalParameters.unique = unique;
		optionalParameters.multirow = multirow;
		return this.createIndex(name, keyPath, optionalParameters);
	}-*/;

	public native IdbIndex index(String name) /*-{
		return this.index(name);
	}-*/;

	public native void deleteIndex(String indexName) /*-{
		this.deleteIndex(indexName);
	}-*/;
}
