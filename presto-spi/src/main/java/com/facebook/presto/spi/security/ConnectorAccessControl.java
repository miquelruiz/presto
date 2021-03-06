/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.spi.security;

import com.facebook.presto.spi.SchemaTableName;

public interface ConnectorAccessControl
{
    /**
     * Check if identity is allowed to create the specified table in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanCreateTable(Identity identity, SchemaTableName tableName);

    /**
     * Check if identity is allowed to drop the specified table in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanDropTable(Identity identity, SchemaTableName tableName);

    /**
     * Check if identity is allowed to rename the specified table in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanRenameTable(Identity identity, SchemaTableName tableName, SchemaTableName newTableName);

    /**
     * Check if identity is allowed to select from the specified table in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanSelectFromTable(Identity identity, SchemaTableName tableName);

    /**
     * Check if identity is allowed to insert into the specified table in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanInsertIntoTable(Identity identity, SchemaTableName tableName);

    /**
     * Check if identity is allowed to delete from the specified table in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanDeleteFromTable(Identity identity, SchemaTableName tableName);

    /**
     * Check if identity is allowed to create the specified view in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanCreateView(Identity identity, SchemaTableName viewName);

    /**
     * Check if identity is allowed to drop the specified view in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanDropView(Identity identity, SchemaTableName viewName);

    /**
     * Check if identity is allowed to select from the specified view in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanSelectFromView(Identity identity, SchemaTableName viewName);

    /**
     * Check if identity is allowed to set the specified property in this catalog.
     * @throws AccessDeniedException if not allowed
     */
    void checkCanSetCatalogSessionProperty(Identity identity, String propertyName);
}
