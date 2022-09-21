package us.fiestaboleana.java.storage;

import java.io.File;
import java.sql.Connection;

public final class SQLite extends SQLDatabase {

    /**
     * Constructs a new SQLite instance, shouldn't be used externally, use {@link SQLHolder} instead
     *
     * @param name The name of the SQLite file
     */
    SQLite(String name, File path) {
        super(null, 0, name, null, null);
        File file = new File(path, this.database.endsWith(".db") ? this.database : this.database + ".db");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dataSource.setJdbcUrl("jdbc:sqlite:" + file.getAbsolutePath());
    }

    /**
     * Returns the Connection for the SQLite Database
     *
     * @return The Connection
     * @see Connection
     */
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = this.dataSource.getConnection();
        } catch (Exception e) {
            logger.log("Failed to connect to the SQLite Database using " + this.database + '!');
        }
        return connection;
    }
}