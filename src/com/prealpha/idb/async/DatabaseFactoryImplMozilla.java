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

package com.prealpha.idb.async;

import com.prealpha.idb.async.jso.IdbFactory;

/**
 * An implementation of {@link DatabaseFactory} for Firefox 4.0.
 * 
 * @author Meyer Kizner
 * @see DatabaseFactoryImpl
 * 
 */
final class DatabaseFactoryImplMozilla extends DatabaseFactoryImpl {
	/**
	 * Constructs a new {@code DatabaseFactoryImplMozilla}.
	 */
	public DatabaseFactoryImplMozilla() {
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * The Mozilla implementation uses the property {@code window.mozIndexedDB}.
	 * The default mechanism for obtaining a peer is used as a fallback.
	 * 
	 * @throws UnsupportedOperationException
	 *             {@inheritDoc}
	 */
	@Override
	protected native IdbFactory getPeer() /*-{
		if ($wnd.mozIndexedDB) {
			return $wnd.mozIndexedDB;
		} else {
			// try to fall back on the default
			return this.@com.prealpha.idb.async.DatabaseFactoryImplMozilla::getDefaultPeer()();
		}
	}-*/;

	/**
	 * A helper method to allow us to get the default peer.
	 * 
	 * @return the default peer
	 */
	private IdbFactory getDefaultPeer() {
		return super.getPeer();
	}
}
