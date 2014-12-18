import com.shields.dbbuilder.InsertSqlBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

}
