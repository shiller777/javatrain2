package com.http.shiller.jdbc;

import com.http.shiller.jdbc.config.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionTakeFactory {
    private List<Long> timeList = new ArrayList<>();

    public static void main(String[] args) {
        ConnectionTakeFactory factory = new ConnectionTakeFactory();
        factory.threadsRun(1000);
        try {
            Thread.sleep(10000);
            factory.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Runnable runnable = () -> {
        Connection connection = ConnectionManager.take();
        System.out.println("TAKEN");
        try {
            Thread.sleep(2000);
            connection.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        timeList.add(System.currentTimeMillis());
    };

    public void threadsRun(int count) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            threads.add(new Thread(runnable));
        }
        for (Thread thread : threads) {
            thread.start();
        }

    }

    private List<Long> printTime() {
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < timeList.size() - 1; i++) {
            Long time1 = timeList.get(i);
            Long time2 = timeList.get(i + 1);
            result.add(time2 - time1);
        }
        return result;
    }

}
