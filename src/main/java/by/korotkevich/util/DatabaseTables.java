package by.korotkevich.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTables {

    static {
        try (Connection connection = ConnectionManager.open()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE \"AUTHOR\" " +
                    "(\"ID_AUTHOR\" BIGINT auto_increment, " +
                    "\"AUTHOR_NAME\" CHARACTER VARYING(255) NOT NULL UNIQUE, " +
                    "CONSTRAINT \"ID_AUTHOR\" PRIMARY KEY (\"ID_AUTHOR\"));" +
                    "CREATE TABLE \"PUBLISHER\" " +
                    "(\"ID_PUBLISHER\" BIGINT auto_increment, " +
                    "\"PUBLISHER_NAME\" CHARACTER VARYING(255) NOT NULL UNIQUE, " +
                    "CONSTRAINT \"ID_PUBLISHER\" PRIMARY KEY (\"ID_PUBLISHER\"));" +
                    "CREATE TABLE \"PRODUCT\" " +
                    "(\"ID_PRODUCT\" BIGINT auto_increment, " +
                    "\"PRODUCT_NAME\" CHARACTER VARYING(255) NOT NULL UNIQUE, " +
                    "\"PRODUCT_DATE\" CHARACTER VARYING(255) NOT NULL, " +
                    "\"ID_AUTHOR\" int, " +
                    "\"ID_PUBLISHER\" int, " +
                    "CONSTRAINT \"ID_PRODUCT\" PRIMARY KEY (\"ID_PRODUCT\"), " +
                    "CONSTRAINT \"PRODUCT_AUTHOR_ID_AUTHOR_FK\" " +
                    "FOREIGN KEY (\"ID_AUTHOR\") REFERENCES \"AUTHOR\" " +
                    "(\"ID_AUTHOR\"), " +
                    "CONSTRAINT \"PRODUCT_PUBLISHER_ID_PUBLISHER_FK\" " +
                    "FOREIGN KEY (\"ID_PUBLISHER\") REFERENCES \"PUBLISHER\" " +
                    "(\"ID_PUBLISHER\"))");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
