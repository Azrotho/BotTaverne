package fr.azrotho.taverne.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class ClearCommand {
    public static void clearChannel(TextChannel channel, int number) {
        channel.getHistory().retrievePast(number).queue(messages -> {
            channel.deleteMessages(messages).queue();
        });
    }
}
