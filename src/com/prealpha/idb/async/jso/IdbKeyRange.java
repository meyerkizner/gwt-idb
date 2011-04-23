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

public final class IdbKeyRange extends JavaScriptObject {
	protected IdbKeyRange() {
	}

	public native Object lower() /*-{
		return this.lower;
	}-*/;

	public native Object upper() /*-{
		return this.upper;
	}-*/;

	public native boolean lowerOpen() /*-{
		return this.lowerOpen;
	}-*/;

	public native boolean upperOpen() /*-{
		return this.upperOpen;
	}-*/;

	public static native IdbKeyRange only(Object value) /*-{
		return IDBKeyRange.only(value);
	}-*/;

	public static native IdbKeyRange lowerBound(Object bound, boolean open) /*-{
		return IDBKeyRange.lowerBound(bound, open);
	}-*/;

	public static native IdbKeyRange upperBound(Object bound, boolean open) /*-{
		return IDBKeyRange.upperBound(bound, open);
	}-*/;

	public static native IdbKeyRange bound(Object lower, Object upper,
			boolean lowerOpen, boolean upperOpen) /*-{
		return IDBKeyRange.bound(lower, upper, lowerOpen, upperOpen);
	}-*/;
}
