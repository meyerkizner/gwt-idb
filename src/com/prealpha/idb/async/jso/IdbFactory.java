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

public final class IdbFactory extends JavaScriptObject {
	protected IdbFactory() {
	}

	public native IdbRequest open(String name) /*-{
		return this.open(name);
	}-*/;

	public native IdbRequest deleteDatabase(String name) /*-{
		return this.deleteDatabase(name);
	}-*/;

	public native int cmp(Object first, Object second) /*-{
		return this.cmp(first, second);
	}-*/;
}
