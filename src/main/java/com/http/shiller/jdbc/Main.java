package com.http.shiller.jdbc;

public class Main {

    //1. Resources
//    static final String DB_DRIVER = "db.driver";
//    static final String DB_URL = "db.url";
//    static final String DB_LOGIN = "db.login";
//    static final String DB_PASSWORD = "db.password";
//    static final String DB_POOL_SIZE = "db.poolsize";
//ResourceBundle properties = ResourceBundle.getBundle("jdbc");

    //2.ConnectionPool
//    given
//    available
//
//      initConnections()
//      connection = DriverManager.getConnection
//          DelegateConnection
//              close
//              setReadOnly, setAutoCommit, given.remove(this), available.offer(this)
//    close sequence - rs, st, con

    //3. Dao
//    statement = con.prepareSt();
//    resultSet = statement.executeQuery();
//    rs.next();
//    close all

//    transactions - commit, rallback

}
