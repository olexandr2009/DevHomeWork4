package org.example.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Configurations {
    private static final String DEFAULT_JSON_CONFIG_FILEPATH = "./src/main/resources/configurations.json";
    public static final String DB_URL = "dbURL";
    public static final String USER_NAME_CONFIG_NAME = "user";
    public static final String PASSWORD_CONFIG_NAME = "password";
    public static final String INIT_DB_SQL = "initDbSql";
    public static final String POPULATE_DB_SQL = "populateDbSql";

    private Map<String,Object> PREFS;
    public Configurations(){
        this(DEFAULT_JSON_CONFIG_FILEPATH);
    }
    public Configurations(String filepath){
        try{
            String join = String.join("\n", Files.readAllLines(Path.of(filepath)));
            PREFS  = new Gson().fromJson(join, TypeToken.getParameterized(Map.class, String.class, Object.class).getType());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public String getConfigAsString(String key){
        return PREFS.get(key).toString();
    }
    public Object getConfig(String key){
        return PREFS.get(key);
    }
}
