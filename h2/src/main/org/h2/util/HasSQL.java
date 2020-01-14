/*
 * Copyright 2004-2020 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (https://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.util;

/**
 * An object that has an SQL representation.
 */
public interface HasSQL {

    /**
     * Quote identifiers only when it is strictly required (different case or
     * identifier is also a keyword).
     */
    int QUOTE_ONLY_WHEN_REQUIRED = 1;

    /**
     * Default flags.
     */
    int DEFAULT_SQL_FLAGS = 0;

    /**
     * Combined flags for trace.
     */
    int TRACE_SQL_FLAGS = QUOTE_ONLY_WHEN_REQUIRED;

    /**
     * Get a medium size SQL expression for debugging or tracing.
     *
     * @return the SQL expression
     */
    default String getTraceSQL() {
        return getSQL(TRACE_SQL_FLAGS);
    }

    /**
     * Get the SQL statement of this expression. This may not always be the
     * original SQL statement, specially after optimization.
     *
     * @param sqlFlags
     *            formatting flags
     * @return the SQL statement
     */
    default String getSQL(int sqlFlags) {
        return getSQL(new StringBuilder(), sqlFlags).toString();
    }

    /**
     * Appends the SQL statement of this object to the specified builder.
     *
     * @param builder
     *            string builder
     * @param sqlFlags
     *            formatting flags
     * @return the specified string builder
     */
    StringBuilder getSQL(StringBuilder builder, int sqlFlags);

}
