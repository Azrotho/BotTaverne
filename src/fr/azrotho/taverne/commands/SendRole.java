package fr.azrotho.taverne.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class SendRole {
    public static void sendRole(Guild guild) {
        guild.getChannelById(TextChannel.class, "714802879285952543").sendMessage("Pour Activer/Désactiver les Notifs Twitch !").addActionRow(
                Button.primary("twitch", "Activer/Désactiver les Notifs Twitch")
        ).queue();
        guild.getChannelById(TextChannel.class, "714802879285952543").sendMessage("Pour Activer/Désactiver les Notifs Youtube !").addActionRow(
                Button.primary("youtube", "Activer/Désactiver les Notifs Youtube")
        ).queue();
        guild.getChannelById(TextChannel.class, "714802879285952543").sendMessage("Pour Activer/Désactiver les Notifs Sondage !").addActionRow(
                Button.primary("sondage", "Activer/Désactiver les Notifs Sondage")
        ).queue();
        guild.getChannelById(TextChannel.class, "714802879285952543").sendMessage("Pour Activer/Désactiver les Notifs TikTok !").addActionRow(
                Button.primary("tiktok", "Activer/Désactiver les Notifs TikTok")
        ).queue();
    }
}
