package us.fiestaboleana.java.storage;


import java.io.File;

public class SQLHolder {
    private final SQLDatabase database;

    public SQLHolder(String database, File file) {
        this.database = new SQLite(database, file);
    }

    public SQLHolder(String hostName, int port, String database, String user, String password) {
        this.database = new MySQL(hostName, port, database, user, password);
    }

    /**
     * Regresa la base de datos SQL asociada con este SQLLoader
     *
     * @return La SQLDatabase
     */
    public SQLDatabase getDatabase() {
        return this.database;
    }

    /**
     * Desconecta de SQLDatabase
     */
    public void disconnect() {
        this.database.disconnect();
    }
}