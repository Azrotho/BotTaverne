package fr.azrotho.taverne.utils;

import fr.azrotho.taverne.Main;
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

    public static void addXP(String id, long amount) {
        if(Main.getXp().get(id) == null){
            Main.getXp().put(id, amount);
            Main.getLevel().put(id, 0L);
        }else {
            long currentXP = Main.getXp().get(id);
            Main.getXp().put(id, currentXP + amount);
        }
        detectLevelup(id);
    }

    public static long getXP(String id) {
        return Main.getXp().get(id);
    }

    public static long getLevel(String id) {
        return Main.getLevel().get(id);
    }

    public static long getXPForNextLevel(String id) {
        long currentLevel = Main.getLevel().get(id);
        long nextLevelXP = 100 * (currentLevel + 1);
        return nextLevelXP;
    }

    public static long getTotalXPForNextLevel(String id){
        long currentLevel = Main.getLevel().get(id);
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
        long currentLevel = Main.getLevel().get(id);
        // Get XP
        long currentXP = Main.getXp().get(id);
        // Calcul current level with XP
        long level = 0;
        long xp = 0;
        while (xp < currentXP) {
            level++;
            xp += 100 * level;
        }
        // If level is different, level up
        if (level != currentLevel) {
            Main.getLevel().put(id, level);
            User user = Main.getUserById().get(id);
            Guild guild = user.getJDA().getGuildById("714802389164752896");
            TextChannel channel = guild.getTextChannelById("714802884511924304");
            channel.sendMessage(user.getAsMention() + " a atteint le niveau " + level + "!").queue();
            return true;
        }else{
            return false;
        }
    }
}
