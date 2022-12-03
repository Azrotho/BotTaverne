package fr.azrotho.taverne.commands;

import fr.azrotho.taverne.Main;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.*;

public class LeaderboardCommand {
    public static void leaderboard(Guild guild, User user, TextChannel channel) {
        // Make a leaderboard with Main.getXP() and Main.getLevel()


        // Sort the leaderboard

        HashMap<String, Long> map = Main.getXp();
        LinkedHashMap<String, Long> sortedMap = new LinkedHashMap<>();
        ArrayList<Long> list = new ArrayList<>();

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (long num : list) {
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }



        // Send the leaderboard
        channel.sendMessage("Leaderboard :").queue();
        int i = 1;
        for (Map.Entry<String, Long> entry : sortedMap.entrySet()) {
            if (i <= 10) {
                User user1 = Main.getUserById().get(entry.getKey());
                channel.sendMessage(i + " - " + user1.getName() + " : Level **" + Main.getLevel().get(user1.getId()) + "**").queue();
                i++;
            }
        }
    }
}
