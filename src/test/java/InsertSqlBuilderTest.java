import com.shields.dbbuilder.InsertSqlBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsertSqlBuilderTest {

    private InsertSqlBuilder builder;
    public static final String TEST_PRIMARY_KEY_ID = "TEST_ID";

    @Before
    public void setUp() {
        builder = new InsertSqlBuilder("TEST_TABLE");
    }

    @Test
    public void autoIncrementedIDColumnStartsWithOne() {
        String expectedSql = "INSERT INTO TEST_TABLE (" + TEST_PRIMARY_KEY_ID + ") VALUES ('1')";
        assertEquals(expectedSql, builder.toString());
    }

    @Test
    public void autoIncrementedIDColumnReturnsTwoWhenCalledTwice() {
        String expectedSql = "INSERT INTO TEST_TABLE (" + TEST_PRIMARY_KEY_ID + ") VALUES ('2')";
        builder.toString();
        assertEquals(expectedSql, builder.toString());
    }

    @Test
    public void tableNameIsSetByBuilder() {
        String tableName = "MY_TEST_TABLE";
        String expectedSql = "INSERT INTO " + tableName + " (" + TEST_PRIMARY_KEY_ID + ") VALUES ('1')";
        assertEquals(expectedSql, new InsertSqlBuilder(tableName).toString());
    }

    @Test
    public void columnNameAndValuePairIsSetByBuilder() {
        String expectedSql = "INSERT INTO TEST_TABLE (" + TEST_PRIMARY_KEY_ID + ", TEST_COLUMN) VALUES ('1', '123')";
        assertEquals(expectedSql, builder.set("TEST_COLUMN", "123").toString());
    }

    @Test
    public void multipleColumnNameAndValuesAreSetByBuilder() {
        String expectedSql = "INSERT INTO TEST_TABLE (" + TEST_PRIMARY_KEY_ID + ", TEST_COLUMN, TEST_COLUMN_TWO) VALUES (1, 123, 234)";
        assertTrue(expectedSql.contains("TEST_COLUMN"));
        assertTrue(expectedSql.contains("TEST_COLUMN_TWO"));
        assertTrue(expectedSql.contains("234"));
    }

    @Test
    public void addSingleQuotesAroundAllValues() {
        String expectedSql = "INSERT INTO TEST_TABLE (" + TEST_PRIMARY_KEY_ID + ", foo) VALUES ('1', 'bar')";
        assertEquals(expectedSql, builder.set("foo", "bar").toString());
    }

    @Test
    public void dontAddSingleQuotesIfInputIsNull() {
        assertTrue(builder.set("foo", "null").toString().contains("null)"));
    }

}
