package fr.azrotho.taverne.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.CustomEmoji;
import net.dv8tion.jda.api.entities.emoji.Emoji;

public class SondageCommand {
    public static void createSondage(Guild guild, String question, String reponse1, String reponse2) {
        TextChannel channel = guild.getChannelById(TextChannel.class, "1038185685821173861");
        channel.sendMessage("Sondage: " + question + "\n\n" + ":red_circle: " + reponse1 + "\n" + ":orange_circle: " + reponse2).queue(message -> {
            message.addReaction(Emoji.fromUnicode("\uD83D\uDD34")).queue();
            message.addReaction(Emoji.fromUnicode("\uD83D\uDFE0")).queue();
        });
    }
    public static void createSondage3(Guild guild, String question1, String reponse1, String reponse2, String reponse3) {
        TextChannel channel = guild.getChannelById(TextChannel.class, "1038185685821173861");
        channel.sendMessage("Sondage: " + question1 + "\n\n" + ":red_circle: " + reponse1 + "\n" + ":orange_circle: " + reponse2 + "\n" + ":green_circle: " + reponse3).queue(message -> {
            message.addReaction(Emoji.fromUnicode("\uD83D\uDD34")).queue();
            message.addReaction(Emoji.fromUnicode("\uD83D\uDFE0")).queue();
            message.addReaction(Emoji.fromUnicode("\uD83D\uDFE2")).queue();
        });
    }
}
