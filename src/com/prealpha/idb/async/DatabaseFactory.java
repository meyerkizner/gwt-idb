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

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Allows client classes to access {@link IdbDatabase}s associated with the current
 * origin. The implementation of this interface is the sole access point to the
 * IndexedDB API. Per the spec (2011-04-19), database names are unique to the
 * origin in which the script is being run.
 * <p>
 * 
 * Any methods of this interface may fail with an
 * {@link UnsupportedOperationException} if the user's browser does not support
 * IndexedDB.
 * 
 * @author Meyer Kizner
 * 
 */
public interface DatabaseFactory {
	/**
	 * Opens a connection to the database with the given name. If the database
	 * does not exist, calling this method will create a new database with no
	 * object stores and return it. Exceptions may be passed to the
	 * {@link AsyncCallback#onFailure(Throwable) onFailure} method of the
	 * callback.
	 * 
	 * @param name
	 *            the name of the database to create or connect to
	 * @param callback
	 *            receives the resulting connection object or exception
	 */
	void getDatabase(String name, AsyncCallback<Database> callback);

	/**
	 * Deletes the database with the specified name. If successful, {@code null}
	 * will be passed as a result to the callback. Exceptions may be passed to
	 * the {@link AsyncCallback#onFailure(Throwable) onFailure} method of the
	 * callback.
	 * 
	 * @param name
	 *            the name of the database to delete
	 * @param callback
	 *            receives {@code null} on success or an exception on failure
	 */
	void deleteDatabase(String name, AsyncCallback<Void> callback);
}
