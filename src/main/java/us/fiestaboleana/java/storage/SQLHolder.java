package us.fiestaboleana.java.storage;


public class SQLHolder {
    private final SQLDatabase database;

    public SQLHolder(SQLDatabase database) {
        this.database = database;
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