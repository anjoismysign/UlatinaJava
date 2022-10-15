package us.fiestaboleana.java.storage;

import com.mongodb.lang.Nullable;
import com.zaxxer.hikari.HikariDataSource;
import us.fiestaboleana.java.objects.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class SQLDatabase extends Logger {
    protected final String database;
    protected final String hostName;
    protected final int port;
    protected final String user;
    protected final String password;
    protected final HikariDataSource dataSource;
    protected final ThreadPoolExecutor executor;

    /**
     * Construye una nueva instancia de SQLDatabase, no debe usarse externamente
     *
     * @param hostName El nombre del host del servidor SQL
     * @param port     El puerto del servidor SQL
     * @param database El nombre de la base de datos SQL
     * @param user     El usuario a usar
     * @param password La contraseña a usar
     */
    protected SQLDatabase(String hostName, int port, String database, String user, String password) {
        this.dataSource = new HikariDataSource();
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.database = database;
        this.hostName = hostName;
        this.port = port;
        this.user = user;
        this.password = password;
        this.dataSource.setUsername(user);
        this.dataSource.setPassword(password);
        this.dataSource.setMaximumPoolSize(200);
        this.dataSource.setMinimumIdle(5);
        this.dataSource.setLeakDetectionThreshold(15000);
        this.dataSource.setConnectionTimeout(1000);
    }

    /**
     * Regresa la conexión para SQLDatabase
     *
     * @return La conexión
     * @see Connection
     */
    public abstract Connection getConnection();

    /**
     * Desconecta de SQLDatabase
     */
    public final void disconnect() {
        try {
            this.executor.shutdown();
            this.dataSource.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Regresa el nombre de esta base de datos
     *
     * @return El nombre de esta base de datos
     */
    public final String getDatabase() {
        return this.database;
    }

    /**
     * Regresa el PreperedStatement de "SELECT * FROM table WHERE keyType='key'".
     * <p>
     * Una vez que se haya terminado de usar, se debe cerrar con {@link PreparedStatement#close()}
     *
     * @param keyType El tipo de clave
     * @param key     La clave
     * @param table   La tabla
     * @return null si no se encuentra. PreparedStatement de lo contrario
     */
    @Nullable
    public PreparedStatement selectAllFromData(String keyType, String key, String table) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + keyType + "='" + key + "'");
            return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * Regresa el PreperedStatement de "UPDATE table SET values WHERE keyType='key'".
     * <p>
     * Una vez que se haya terminado de usar, se debe cerrar con {@link PreparedStatement#close()}
     *
     * @param keyType El tipo de clave
     * @param table   La tabla
     * @param values  Los valores
     * @return null si no se encuentra. PreparedStatement de lo contrario
     */
    public PreparedStatement updateDataSet(String keyType, String table, String values) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + table + " SET " + values + " WHERE " + keyType + "=?");
            return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
