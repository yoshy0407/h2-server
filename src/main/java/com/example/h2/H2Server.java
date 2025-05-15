package com.example.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.h2.tools.Server;

public class H2Server {

    public static void main(String[] args) {
        // DBを先に作る（同じJVM内）
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./data/test;MODE=PostgreSQL", "sa", "")) {
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name TEXT)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Server server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            System.out.println("H2コンソールが起動しました: " + server.getURL());
            Thread.currentThread().join(); // プロセスを止めない
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
