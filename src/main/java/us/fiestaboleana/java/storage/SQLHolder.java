package us.fiestaboleana.java.storage;


public class SQLHolder {
    private final SQLDatabase database;

    public SQLHolder(SQLDatabase database) {
        this.database = database;
    }

    /**
     * Returns the SQLDatabase associated with this SQLLoader
     *
     * @return The SQLDatabase
     */
    public SQLDatabase getDatabase() {
        return this.database;
    }

    /**
     * Disconnects from the SQLDatabase
     */
    public void disconnect() {
        this.database.disconnect();
    }
}