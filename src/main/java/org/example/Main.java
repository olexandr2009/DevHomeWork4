package org.example;

import org.example.database.Database;
import org.example.prefs.Configurations;

public class Main {
    public static void main(String[] args) {
        Database.getInstance().getConnection();
    }
}