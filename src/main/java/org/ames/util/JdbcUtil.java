package org.ames.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

    // for connecting to DB by using JDBC

    // need below 4 information:


    private static final String DRIVER = "org.postgresql.Driver";

    private static final String URL = "jdbc:postgresql://ep-royal-block-60540290.us-east-2.aws.neon.tech/database-demo?user=kouyixiao86&password=PHrA15zgadGL";
//    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
//    private static final String USERNAME = "kouyixiao86";
//    private static final String PASSWORD = "PHrA15zgadGL";


    public static Connection getConnection() {

        Connection conn = null;

        try {

            // Class.forName() will load the class during runtime

            Class.forName(DRIVER);

//            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            conn = DriverManager.getConnection(URL);

        } catch (Exception e) {

            System.err.println(e);

        }

        return conn;

    }


}
