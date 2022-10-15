package us.fiestaboleana.java.storage;

import java.sql.Connection;
import java.sql.SQLException;

public final class MySQL extends SQLDatabase {
    protected MySQL(String hostName, int port, String database, String user, String password) {
        super(hostName, port, database, user, password);
        dataSource.setJdbcUrl("jdbc:mysql://" + this.hostName + ':' + this.port + '/' + this.database);
    }

    /**
     * Regresa la conexión para la base de datos MySQL
     *
     * @return La conexión
     * @see Connection
     */
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            singleError("Failed to connect to 'MySQL' Database using following credentials:");
            singleError("Hostname: " + hostName);
            singleError("Port: " + port);
            singleError("Database: " + database);
            singleError("User: " + user);
            singleError("Password: -EXPUNGED-");
        }
        return connection;
    }
}