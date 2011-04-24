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

public final class IdbIndex extends JavaScriptObject {
	protected IdbIndex() {
	}

	public native String name() /*-{
		return this.name;
	}-*/;

	public native IdbObjectStore objectStore() /*-{
		return this.objectStore;
	}-*/;

	public native String keyPath() /*-{
		return this.keyPath;
	}-*/;

	public native boolean unique() /*-{
		return this.unique;
	}-*/;

	public native IdbRequest openCursor(IdbKeyRange range, int direction)
			throws IndexedDbException /*-{
		try {
			return this.openCursor(range, direction);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public native IdbRequest openKeyCursor(IdbKeyRange range, int direction)
			throws IndexedDbException /*-{
		try {
			return this.openKeyCursor(range, direction);
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

	public native IdbRequest getKey(Object key) throws IndexedDbException /*-{
		try {
			return this.getKey(key);
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;
}
