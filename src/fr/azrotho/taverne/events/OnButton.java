package fr.azrotho.taverne.events;

import fr.azrotho.taverne.utils.TicketCreation;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.EnumSet;

public class OnButton extends ListenerAdapter {

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("twitch")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1038202526115311679"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1038202526115311679")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1038202526115311679").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1038202526115311679")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1038202526115311679").getAsMention()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals("youtube")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1038205477571543080"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1038205477571543080")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1038205477571543080").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1038205477571543080")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1038205477571543080").getAsMention()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals("sondage")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1038205385544314890"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1038205385544314890")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1038205385544314890").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1038205385544314890")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1038205385544314890").getAsMention()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals("tiktok")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1038205553081597972"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1038205553081597972")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1038205553081597972").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1038205553081597972")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1038205553081597972").getAsMention()).setEphemeral(true).queue();
            }

        }
        if (event.getButton().getId().equals("il")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1043541369005817959"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1043541369005817959")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1043541369005817959").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1043541369005817959")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1043541369005817959").getAsMention()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals("elle")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1043541704382357585"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1043541704382357585")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1043541704382357585").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1043541704382357585")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1043541704382357585").getAsMention()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals("iel")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1043541479798345850"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1043541479798345850")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1043541479798345850").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1043541479798345850")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1043541479798345850").getAsMention()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals("ask")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1043541506771914843"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1043541506771914843")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1043541506771914843").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1043541506771914843")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1043541506771914843").getAsMention()).setEphemeral(true).queue();
            }
        }
        if (event.getButton().getId().equals("autre")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1043541812444401767"))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("1043541812444401767")).queue();
                event.reply("Vous avez quitté le rôle: " + event.getGuild().getRoleById("1043541812444401767").getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1043541812444401767")).queue();
                event.reply("Vous avez rejoint le rôle: " + event.getGuild().getRoleById("1043541812444401767").getAsMention()).setEphemeral(true).queue();
            }
        }
        if(event.getButton().getId().equals("ticket")){
            TicketCreation.createTicket(event.getMember());
        }
        if(event.getButton().getId().equals("closeticket")){
                event.getChannel().asTextChannel().upsertPermissionOverride(event.getMember()).setDenied(EnumSet.of(Permission.VIEW_CHANNEL)).queue();
                event.getChannel().sendMessage("Vous avez fermé le ticket").queue();
                event.getChannel().asTextChannel().getManager().setName("fermer-" + event.getUser().getName()).queue();
        }
    }
}
