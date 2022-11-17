package us.fiestaboleana.java.storage;

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
     * Selecciona todos los datos de una tabla y los regresa en un PreparedStatement
     *
     * @param keyType El tipo de clave de la tabla
     * @param key     La clave de la tabla
     * @param table   La tabla
     * @return El PreparedStatement
     */
    public PreparedStatement selectAllFromData(String keyType, String key, String table) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + keyType + "='" + key + "'");
            return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Actualiza un set de datos en una tabla
     *
     * @param keyType El tipo de clave de la tabla
     * @param table   La tabla
     * @param values  Los valores a actualizar
     * @return El PreparedStatement
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
        }
    }

    /**
     * Crea una nueva tabla
     *
     * @param table      La tabla
     * @param columns    Las columnas
     * @param primaryKey La clave primaria
     */
    public void createTable(String table, String columns, String primaryKey) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS " + table + " (" + columns + ",PRIMARY KEY(" + primaryKey + "))");
            try {
                preparedStatement.executeUpdate();
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                if (preparedStatement != null)
                    try {
                        preparedStatement.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                e.printStackTrace();
            } finally {
                if (preparedStatement != null)
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
     * Confirma si una tabla existe
     *
     * @param table   La tabla
     * @param keyType El tipo de clave de la tabla
     * @param key     La clave de la tabla
     * @return "true" Si la tabla existe, "false" si no existe
     */
    public boolean exists(String table, String keyType, String key) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + keyType + "='" + key + "'");
            try {
                return preparedStatement.executeQuery().next();
            } catch (Throwable throwable) {
                if (preparedStatement != null)
                    try {
                        preparedStatement.close();
                    } catch (Throwable throwable1) {
                        throwable.addSuppressed(throwable1);
                    }
                throw throwable;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return false;
    }
}
