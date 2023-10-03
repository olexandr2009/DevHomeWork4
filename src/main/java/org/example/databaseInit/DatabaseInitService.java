package org.example.databaseInit;

import org.example.database.Database;
import org.example.prefs.Configurations;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class DatabaseInitService {

    public static void initDatabase(Database database){
        try {
            String[] sqlScript = Files.readString(
                                Path.of(new Configurations().getConfigAsString(Configurations.INIT_DB_SQL)),
                                StandardCharsets.UTF_8
                             ).split(";");
            for (String sql:sqlScript){
                database.executeUpdate(sql +";");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        initDatabase(Database.getInstance());
    }

}
