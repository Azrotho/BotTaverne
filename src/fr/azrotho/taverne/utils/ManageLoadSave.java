package fr.azrotho.taverne.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.azrotho.taverne.Main;

import java.io.File;
import java.util.HashMap;

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
        String json = FileUtil.loadContent(new File("xp.json"));
        HashMap<String, Long> xp = gson.fromJson(json, HashMap.class);
        Main.getXp().putAll(xp);
        // Load Level
        json = FileUtil.loadContent(new File("level.json"));
        HashMap<String, Long> level = gson.fromJson(json, HashMap.class);
        Main.getLevel().putAll(level);
    }
}
