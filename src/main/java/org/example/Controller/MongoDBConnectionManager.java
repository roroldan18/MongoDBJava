package org.example.Controller;

public class MongoDBConnectionManager {
    private static MongoDBConnection connection;

    public static MongoDBConnection getConnection() {
        if (connection == null) {
            String connectionString = "mongodb://localhost:27017";
            String databaseName = "musica";
            connection = new MongoDBConnection(connectionString, databaseName);
        }
        return connection;
    }
}
