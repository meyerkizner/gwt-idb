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

public class IdbRequest extends JavaScriptObject {
	protected IdbRequest() {
	}

	public final native Object result() throws IndexedDbException /*-{
		try {
			return this.result;
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public final native int errorCode() throws IndexedDbException /*-{
		try {
			return this.errorCode;
		} catch (err) {
			$wnd.handleIdbx(err);
		}
	}-*/;

	public final native JavaScriptObject source() /*-{
		return this.source;
	}-*/;

	public final native IdbTransaction transaction() /*-{
		return this.transaction;
	}-*/;

	public final native int readyState() /*-{
		return this.readyState;
	}-*/;

	public final native void onsuccess(Callback callback) /*-{
		this.onsuccess = function(event) {
			callback.@com.prealpha.idb.async.jso.Callback::run(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
		};
	}-*/;

	public final native void onerror(Callback callback) /*-{
		this.onerror = function(event) {
			callback.@com.prealpha.idb.async.jso.Callback::run(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
		};
	}-*/;
}
