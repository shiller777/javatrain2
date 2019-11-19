package com.http.shiller.jdbc.config;

abstract class SQLData {
    static final String DB_DRIVER = "db.driver";
    static final String DB_URL = "db.url";
    static final String DB_LOGIN = "db.login";
    static final String DB_PASSWORD = "db.password";
    static final String DB_POOL_SIZE = "db.poolsize";

    String driver;
    String url;
    String login;
    String password;
    String pool_size;

    public SQLData() {
        init();
    }

    protected abstract void init();

    String getDriver() {
        return driver;
    }

    String getUrl() {
        return url;
    }

    String getLogin() {
        return login;
    }

    String getPassword() {
        return password;
    }

    String getPoolSize() {
        return pool_size;
    }
}
