package com.http.shiller.jdbc.config;

import java.util.ResourceBundle;

class JDBCData extends SQLData {
    private static final String PATH_TO_PROPERTIES = "jdbc";

    @Override
    protected void init() {
        ResourceBundle bundle = ResourceBundle.getBundle(PATH_TO_PROPERTIES);

        this.url = bundle.getString(DB_URL);
        this.driver = bundle.getString(DB_DRIVER);
        this.login = bundle.getString(DB_LOGIN);
        this.password = bundle.getString(DB_PASSWORD);
        this.pool_size = bundle.getString(DB_POOL_SIZE);
    }
}
