package fr.azrotho.taverne.utils;

import fr.azrotho.taverne.Main;
import fr.azrotho.taverne.objects.Players;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class XPManager {
    // Level 1 = 100 XP
    // Level 2 = 200 XP (300 Total XP)
    // Level 3 = 300 XP (600 Total XP)
    // Level 4 = 400 XP (1000 Total XP)

    // xp = Main.getXp();
    // level = Main.getLevel();


    public static long getTotalXPForNextLevel(String id){
        Players player = Main.players.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        long currentLevel = player.getLevel();
        long nextLevelXP = 100 * (currentLevel);
        long totalXP = nextLevelXP;
        for(long i = 1; i < currentLevel; i++){
            totalXP += 100 * i;
        }
        return totalXP;
    }

    public static boolean detectLevelup(String id) {
        System.out.println("Detecting levelup for " + id);
        // Get Level
        Players player = Main.players.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        long currentLevel = player.getLevel();
        // Get XP
        long currentXP = player.getXp();
        // Calcul current level with XP
        long level = 0;
        long xp = 0;
        while (xp < currentXP) {
            level++;
            xp += 100 * level;
        }
        // If level is different, level up
        if (level != currentLevel) {
            player.setLevel((int) level);
            return true;
        }else{
            return false;
        }
    }
}
