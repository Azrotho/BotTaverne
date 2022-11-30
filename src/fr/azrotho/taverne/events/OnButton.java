package fr.azrotho.taverne.events;

import fr.azrotho.taverne.Main;
import fr.azrotho.taverne.utils.TicketCreation;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class OnButton extends ListenerAdapter {


    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {

        Map<String, String> roles = new HashMap<String, String>();

        roles.put("twitch","1038202526115311679");
        roles.put("youtube","1038205477571543080");
        roles.put("sondage","1038205385544314890");
        roles.put("tiktok","1038205553081597972");
        roles.put("twitter","1038205650000003072");
        roles.put("il", "1043541369005817959");
        roles.put("elle", "1043541704382357585");
        roles.put("iel", "1043541479798345850");
        roles.put("ask", "1043541506771914843");
        roles.put("autre", "1043541812444401767");


        System.out.println(event.getButton().getId());

        if(roles.containsKey(event.getButton().getId())) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById(roles.get(event.getButton().getId())))) {
                event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(roles.get(event.getButton().getId()))).queue();
                event.reply("Vous avez ajouté le rôle: " + event.getGuild().getRoleById(roles.get(event.getButton().getId())).getAsMention()).setEphemeral(true).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(roles.get(event.getButton().getId()))).queue();
                event.reply("Vous avez retiré le rôle: " + event.getGuild().getRoleById(roles.get(event.getButton().getId())).getAsMention()).setEphemeral(true).queue();
            }
        }

        if(event.getButton().getId().equals("ticket")){
            TicketCreation.createTicket(event.getMember());
        }
        if(event.getButton().getId().equals("closeticket")){
                event.getChannel().asTextChannel().getManager().putPermissionOverride(event.getMember(), null, EnumSet.of(Permission.VIEW_CHANNEL)).queue();
                event.getChannel().sendMessage("Vous avez fermé le ticket").queue();
                event.getChannel().asTextChannel().getManager().setName("fermer-" + event.getUser().getName()).queue();
        }
    }
}
