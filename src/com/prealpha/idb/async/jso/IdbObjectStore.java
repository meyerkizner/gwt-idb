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

	public native IdbRequest put(Object value) throws IndexedDbException /*-{
		try {
			return this.put(value);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest put(Object value, Object key)
			throws IndexedDbException /*-{
		try {
			return this.put(value, key);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest add(Object value) throws IndexedDbException /*-{
		try {
			return this.add(value);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest add(Object value, Object key)
			throws IndexedDbException /*-{
		try {
			return this.add(value, key);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest delete(Object key) throws IndexedDbException /*-{
		try {
			// TODO: hack to allow access
			this["delete"](key);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest get(Object key) throws IndexedDbException /*-{
		try {
			return this.get(key);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest clear() throws IndexedDbException /*-{
		try {
			return this.clear();
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest openCursor(IdbKeyRange range, int direction)
			throws IndexedDbException /*-{
		try {
			return this.openCursor(range, direction);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbIndex createIndex(String name, String keyPath,
			boolean unique, boolean multirow) throws IndexedDbException /*-{
		try {
			var optionalParameters = {};
			optionalParameters.unique = unique;
			optionalParameters.multirow = multirow;
			return this.createIndex(name, keyPath, optionalParameters);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbIndex index(String name) throws IndexedDbException /*-{
		try {
			return this.index(name);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native void deleteIndex(String indexName) throws IndexedDbException /*-{
		try {
			this.deleteIndex(indexName);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;
}
