package fr.azrotho.taverne.utils;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.EnumSet;

public class TicketCreation {
    public static void createTicket(Member member) {
        member.getUser().openPrivateChannel().queue(privateChannel -> {
            privateChannel.sendMessage("Vous avez créé un ticket!").queue();
        });
        // Create channel and add member to it
        member.getGuild().createTextChannel("ticket-" + member.getUser().getName()).queue(channel -> {
            channel.upsertPermissionOverride(member).setAllowed(EnumSet.of(Permission.VIEW_CHANNEL)).queue();
            channel.upsertPermissionOverride(member.getGuild().getPublicRole()).setDenied(EnumSet.of(Permission.VIEW_CHANNEL)).queue();
            channel.sendMessage("Bienvenue dans votre ticket " + member.getAsMention() + "!").addActionRow(
                    Button.primary("closeticket", "Fermer le ticket")
            ).queue();
        });
    }
}
