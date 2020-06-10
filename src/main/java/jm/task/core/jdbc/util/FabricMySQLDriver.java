package jm.task.core.jdbc.util;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class FabricMySQLDriver implements Driver {
    @Override
    public Connection connect(String url, Properties info) {
        return null;
    }

    @Override
    public boolean acceptsURL(String url) {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() {
        return null;
    }
}
