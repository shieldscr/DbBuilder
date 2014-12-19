package com.shields.dbbuilder;

import java.util.HashMap;
import java.util.Map;

public class InsertSqlBuilder {

    String insertSql;
    private int Id;
    private String tableName;
    private Map<String, String> ValueMap;

    public InsertSqlBuilder(String tableName) {
        this.tableName = tableName;
        Id = 0;
        ValueMap = new HashMap<String, String>();
    }

    @Override
    public String toString() {
        Id++;
        String columns =  "TEST_ID" + ", ";
        String values = String.format("'%d', ", Id);
        for (Map.Entry<String, String> entry : ValueMap.entrySet()) {
            columns += entry.getKey() + ", ";
            if (entry.getValue().equalsIgnoreCase("null")) {
                values += entry.getValue() + ", ";
            } else {
                values += "'" + entry.getValue() + "', ";
            }
        }
        columns = columns.substring(0, columns.length() - 2);
        values = values.substring(0, values.length() - 2);
        insertSql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, values).trim();
        return insertSql;
    }

    public InsertSqlBuilder set(String columnName, String value) {
        ValueMap.put(columnName, value);
        return this;
    }
}
