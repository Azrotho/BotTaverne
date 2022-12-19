package fr.azrotho.taverne.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.azrotho.taverne.Main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class ManageLoadSave {
    public static void save() {
        // Save XP in json
        // Save Level in json

        Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();
        // Save XP
        String json = gson.toJson(Main.getXp());
        FileUtil.save(new File("xp.json"), json);
        // Save Level
        json = gson.toJson(Main.getLevel());
        FileUtil.save(new File("level.json"), json);
    }
public static void load() {
        // Load XP in json
        // Load Level in json

        Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();
        // Load XP
        File file = new File("xp.json");
        if (file.exists()) {
            String json = FileUtil.loadContent(file);
            HashMap<String, Long> map = gson.fromJson(json, HashMap.class);
            for(Map.Entry<String, Long> entry : map.entrySet()) {
                Main.getXp().put(entry.getKey(), entry.getValue());
            }
        }else{
            FileUtil.save(file, "{}");
        }
        // Load Level
        File file1 = new File("level.json");
        if (file1.exists()) {
            String json = FileUtil.loadContent(file1);
            HashMap<String, Long> map = gson.fromJson(json, HashMap.class);
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                Main.getLevel().put(entry.getKey(), entry.getValue());
            }
        }else{
            FileUtil.save(file1, "{}");
        }
    }
}
