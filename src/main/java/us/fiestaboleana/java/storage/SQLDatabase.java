package us.fiestaboleana.java.storage;

import com.zaxxer.hikari.HikariDataSource;
import us.fiestaboleana.java.objects.Logger;

import java.sql.Connection;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class SQLDatabase {
    protected final Logger logger;
    protected final String database;
    protected final String hostName;
    protected final int port;
    protected final String user;
    protected final String password;
    protected final HikariDataSource dataSource;
    protected final ThreadPoolExecutor executor;

    /**
     * Constructs a new SQLDatabase instance, shouldn't be used externally
     *
     * @param hostName The host name of the SQL Server
     * @param port     The port of the SQL Server
     * @param database The name of the SQL Database
     * @param user     The user to use
     * @param password The password to use
     */
    protected SQLDatabase(String hostName, int port, String database, String user, String password) {
        this.dataSource = new HikariDataSource();
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.logger = new Logger();
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
     * Returns the Connection for the SQLDatabase
     *
     * @return The Connection
     * @see Connection
     */
    public abstract Connection getConnection();

    /**
     * Disconnects from the SQLDatabase
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
     * Returns the name of this Storage
     *
     * @return The name of this Storage
     */
    public final String getDatabase() {
        return this.database;
    }
}
