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

public class IdbCursor extends JavaScriptObject {
	protected IdbCursor() {
	}
	
	public final native JavaScriptObject source() /*-{
		return this.source;
	}-*/;
	
	public final native int direction() /*-{
		return this.direction;
	}-*/;
	
	public final native Object key() /*-{
		return this.key;
	}-*/;
	
	public final native Object primaryKey() /*-{
		return this.primaryKey;
	}-*/;
	
	public final native IdbRequest update(Object value) /*-{
		return this.update(value);
	}-*/;
	
	public final native void advance(int count) /*-{
		this.advance(count);
	}-*/;
	
	/*
	 * XXX: renamed from continue()
	 */
	public final native void next() /*-{
		this.continue();
	}-*/;
	
	public final native void next(Object key) /*-{
		this.continue(key);
	}-*/;
	
	public final native IdbRequest delete() /*-{
		return this.delete();
	}-*/;
}
