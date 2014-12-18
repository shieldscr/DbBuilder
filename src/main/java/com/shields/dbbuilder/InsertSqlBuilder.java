package com.shields.dbbuilder;


public class InsertSqlBuilder {

    private int ID;
    private String TABLE_NAME;

    public InsertSqlBuilder(String tableName) {
        TABLE_NAME = tableName;
        ID = 0;
    }

    @Override
    public String toString() {
        return "INSERT INTO TEST_TABLE (TEST_ID) VALUES ('1')";
    }
}
