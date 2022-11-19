package fr.azrotho.taverne.events;

import fr.azrotho.taverne.commands.*;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

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
            case "say":
                if(event.getMember().hasPermission(Permission.ADMINISTRATOR)){
                    event.getChannel().sendMessage(event.getOption("message").getAsString()).queue();
                    event.reply("Vous avez dit: " + event.getOption("message").getAsString()).setEphemeral(true).queue();
                }else{
                    event.reply("Vous n'êtes pas mon maître.").setEphemeral(true).queue();
                }
                break;
            case "reply":
                if(event.getMember().hasPermission(Permission.ADMINISTRATOR)){
                    event.getMessageChannel().retrieveMessageById(event.getOption("id").getAsLong()).queue(message -> message.reply(event.getOption("message").getAsString()).queue());
                    event.reply("Vous avez répondu: " + event.getOption("message").getAsString()).setEphemeral(true).queue();
                }else{
                    event.reply("Vous n'êtes pas mon maître.").setEphemeral(true).queue();
                }
                break;
            case "senddm":
                if(event.getMember().hasPermission(Permission.ADMINISTRATOR)){
                    event.getOption("user").getAsUser().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(event.getOption("message").getAsString()).queue());
                    event.reply("Vous avez envoyé un message privé à " + event.getOption("user").getAsUser().getAsMention() + " : " + event.getOption("message").getAsString()).setEphemeral(true).queue();
                }else{
                    event.reply("Vous n'êtes pas mon maître.").setEphemeral(true).queue();
                }
                break;
            case "sendticket":
                if(event.getMember().hasPermission(Permission.ADMINISTRATOR)){
                    event.getChannel().asTextChannel().sendMessage("Cliquer pour ouvrir un Ticket").addActionRow(Button.primary("ticket", "Ouvrir un Ticket")).queue();
                }else{
                    event.reply("Vous n'êtes pas mon maître.").setEphemeral(true).queue();
                }
                break;
        }
    }
}
