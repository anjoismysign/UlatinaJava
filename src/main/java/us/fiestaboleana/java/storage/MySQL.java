package us.fiestaboleana.java.storage;

import java.sql.Connection;
import java.sql.SQLException;

public final class MySQL extends SQLDatabase {

    /**
     * Constructs a new MySQL instance, shouldn't be used externally, use {@link SQLHolder} instead
     *
     * @param hostName The host name of the MySQL Server
     * @param port     The port of the MySQL Server
     * @param database The name of the MySQL Database
     * @param user     The user to use
     * @param password The password to use
     */
    public MySQL(String hostName, int port, String database, String user, String password) {
        super(hostName, port, database, user, password);
        this.dataSource.setJdbcUrl("jdbc:mysql://" + this.hostName + ':' + this.port + '/' + this.database);
    }

    /**
     * Returns the Connection for the MySQL Database
     *
     * @return The Connection
     * @see Connection
     */
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = this.dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log("Failed to connect to the MySQL Database using following credentials:");
            logger.log("HostName: " + this.hostName);
            logger.log("Port: " + this.port);
            logger.log("Database: " + this.database);
            logger.log("User: " + this.user);
            logger.log("Password: =REDACTED=");
        }
        return connection;
    }
}