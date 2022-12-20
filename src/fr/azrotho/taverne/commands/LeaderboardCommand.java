package fr.azrotho.taverne.commands;

import fr.azrotho.taverne.Main;
import fr.azrotho.taverne.objects.Players;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.*;

public class LeaderboardCommand {
    public static void leaderboard(Guild guild, User user, TextChannel channel) {
        // Make a leaderboard with Players XP

        // Get all players
        List<Players> players = Main.players;
        // Sort players by XP
        Collections.sort(players, Comparator.comparing(Players::getXp).reversed());
        // Get top 10 players
        int i = 0;
        List<Players> top10 = new ArrayList<>();
        for (Players player : players) {
            if (i < 10) {
                top10.add(player);
                i++;
            }
        }
        // Send leaderboard

        StringBuilder leaderboard = new StringBuilder();
        leaderboard.append("--- Leaderboard ---\n");
        for (Players player : top10) {

            leaderboard.append(player.getName() + ": Level **" + player.getLevel() + "**\n");
        }
        channel.sendMessage(leaderboard.toString()).queue();
    }
}
