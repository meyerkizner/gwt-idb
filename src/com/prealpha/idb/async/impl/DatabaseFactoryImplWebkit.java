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

package com.prealpha.idb.async.impl;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An implementation of {@link DatabaseFactory} for Chrome 11.
 * 
 * @author Meyer Kizner
 * @see DatabaseFactoryImpl
 * 
 */
final class DatabaseFactoryImplWebkit extends DatabaseFactoryImpl {
	/**
	 * Constructs a new {@code DatabaseFactoryImplWebkit}.
	 */
	public DatabaseFactoryImplWebkit() {
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * The Webkit implementation uses the property
	 * {@code window.webkitIndexedDB}. The default mechanism for obtaining a
	 * peer is used as a fallback.
	 * 
	 * @throws UnsupportedOperationException
	 *             {@inheritDoc}
	 */
	@Override
	protected native JavaScriptObject getPeer() /*-{
		if ($wnd.webkitIndexedDB) {
			return $wnd.webkitIndexedDB;
		} else {
			// try to fall back on the default
			return this.@com.prealpha.idb.async.impl.DatabaseFactoryImplWebkit::getDefaultPeer()();
		}
	}-*/;

	/**
	 * A helper method to allow us to get the default peer.
	 * 
	 * @return the default peer
	 */
	private JavaScriptObject getDefaultPeer() {
		return super.getPeer();
	}
}
