package fr.azrotho.taverne.events;

import fr.azrotho.taverne.commands.*;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OnCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "ping":
                event.reply("Pong ! :ping_pong:").queue();
                break;
            case "miaou":
                event.reply("Miaou ! :cat:").queue();
                break;
            case "sondage":
                if(event.getOption("réponse3")!= null){
                    SondageCommand.createSondage3(event.getGuild(), event.getOption("question").getAsString(), event.getOption("réponse1").getAsString(), event.getOption("réponse2").getAsString(), event.getOption("réponse3").getAsString());
                }else {
                    SondageCommand.createSondage(event.getGuild(), event.getOption("question").getAsString(), event.getOption("réponse1").getAsString(), event.getOption("réponse2").getAsString());
                }
                event.reply("Sondage créé !").queue();
                break;
            case "warn":
                WarnCommand.warnUser(event.getChannel().asTextChannel(), event.getOption("user").getAsMember(), event.getOption("user").getAsUser(), event.getOption("reason").getAsString());
                event.reply("Vous avez warn " + event.getOption("user").getAsUser().getAsMention() + " pour: " + event.getOption("reason").getAsString()).setEphemeral(true).queue();
                break;
            case "clear":
                ClearCommand.clearChannel(event.getChannel().asTextChannel(), (int) event.getOption("nombre").getAsLong());
                event.reply("Vous avez clear " + event.getOption("nombre").getAsLong() + " messages").setEphemeral(true).queue();
                break;
            case "sendrole":
                SendRole.sendRole(event.getGuild());
                break;
            case "giverole":
                if(event.getMember().hasPermission(Permission.ADMINISTRATOR)){
                    GiveRoleCommand.giveRole(event.getGuild(), event.getOption("role").getAsRole());
                    event.reply("Vous avez donné le rôle " + event.getOption("role").getAsRole().getAsMention() + " à tous les membres du serveur").setEphemeral(true).queue();
                }
                break;
            case "youtube":
                event.reply("https://r.azrotho.fr/youtube").setEphemeral(true).queue();
                break;
            case "youtubevod":
                event.reply("https://r.azrotho.fr/youtubevod").setEphemeral(true).queue();
                break;
            case "twitch":
                event.reply("https://r.azrotho.fr/twitch").setEphemeral(true).queue();
                break;
            case "tiktok":
                event.reply("https://r.azrotho.fr/tiktok").setEphemeral(true).queue();
                break;
            case "wishlist":
                event.reply("Liste de souhait de Azrotho: \n\n- Casque VR (Meta Quest 2) \n- Slime VR *(en fullbody tracking :3)* \n- Persona 5 Royal sur Steam \n- Des Bonbons \n- 32 Go de RAM *(16x2)*").setEphemeral(true).queue();
                break;
        }
    }
}
