package com.shields.dbbuilder;


public class InsertSqlBuilder {

    private int Id;
    private String tableName;

    public InsertSqlBuilder(String tableName) {
        this.tableName = tableName;
        Id = 0;
    }

    @Override
    public String toString() {
        Id++;
        return String.format("INSERT INTO %s (TEST_ID) VALUES ('%s')",tableName , Id);
    }
}
