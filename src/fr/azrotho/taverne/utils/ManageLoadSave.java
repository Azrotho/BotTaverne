package fr.azrotho.taverne.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.azrotho.taverne.Main;
import fr.azrotho.taverne.objects.Players;

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
        // Save Players
        for (Players players : Main.players) {
            FileUtil.save(new File("players/" + players.getId() + ".json"), gson.toJson(players));
        }
    }

        public static void load () {
            Gson gson = new Gson();
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            gson = builder.create();
            File folder = new File("players");
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String content = FileUtil.loadContent(file);
                    Players players = gson.fromJson(content, Players.class);
                    Main.players.add(players);
                }
            }
        }
    }