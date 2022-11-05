package fr.azrotho.taverne.events;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

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
    }
}
