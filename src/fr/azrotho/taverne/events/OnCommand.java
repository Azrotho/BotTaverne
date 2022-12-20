package fr.azrotho.taverne.events;

import fr.azrotho.taverne.Main;
import fr.azrotho.taverne.commands.*;
import fr.azrotho.taverne.objects.Players;
import fr.azrotho.taverne.utils.XPManager;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.lang.reflect.Member;

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
                    if(event.getOption("réponse4")!=null){
                        SondageCommand.createSondage4(event.getGuild(), event.getOption("question").getAsString(), event.getOption("réponse1").getAsString(), event.getOption("réponse2").getAsString(), event.getOption("réponse3").getAsString(), event.getOption("réponse4").getAsString());
                    }else {
                        SondageCommand.createSondage3(event.getGuild(), event.getOption("question").getAsString(), event.getOption("réponse1").getAsString(), event.getOption("réponse2").getAsString(), event.getOption("réponse3").getAsString());
                    }
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
            case "resetxp":
                if(event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                    User user = event.getOption("user").getAsUser();
                    if (user != null) {
                        Players players = Main.players.stream().filter(p -> p.getId().equals(event.getUser().getId())).findFirst().orElse(null);
                        if (players != null) {
                            players.setXp(0);
                            players.setLevel(0);
                            event.reply("Vous avez reset l'xp de " + user.getAsMention()).setEphemeral(true).queue();
                        }
                    } else {
                        event.reply("Vous n'êtes pas mon maître.").setEphemeral(true).queue();
                    }
                }
                break;
            case "xp":
                if(event.getOption("user") == null) {
                    Players players = Main.players.stream().filter(p -> p.getId().equals(event.getUser().getId())).findFirst().orElse(null);
                    if(players != null) {
                        event.reply("Votre level "+ "est " + players.getLevel() + "\n" + "Votre progression:" + players.getXp() +  "/" + XPManager.getTotalXPForNextLevel(players.getId())).setEphemeral(true).queue();
                    }else{
                        event.reply("Vous n'avez jamais envoyé de message :x").setEphemeral(true).queue();
                    }
                }else{
                    Players players = Main.players.stream().filter(p -> p.getId().equals(event.getOption("user").getAsUser().getId())).findFirst().orElse(null);
                    if(players != null) {
                        Long xp = players.getXp();
                        int level = players.getLevel();
                        event.reply("Le level de " + event.getOption("user").getAsUser().getAsMention() + " est " + level + "\n" + "Progression:" + players.getXp() + "/" + XPManager.getTotalXPForNextLevel(players.getId())).setEphemeral(true).queue();
                    }else{
                        event.reply("Zut, cette personne n'a jamais parlé :x").setEphemeral(true).queue();
                    }
                }
                break;
            case "leaderboard":
                LeaderboardCommand.leaderboard(event.getGuild(), event.getUser(), event.getChannel().asTextChannel());
                event.reply("Vous avez demandé le leaderboard").setEphemeral(true).queue();
                break;
            case "sendaddharuki":
                event.getChannel().sendMessage("Ajoutez Haruki à votre Serveur ça arrive bientôt!").setActionRow(Button.link("https://discord.com/oauth2/authorize?client_id=1048696324914171914&permissions=8&scope=bot%20applications.commands", "Ajouter Haruki")).queue();
                event.reply("OK!").setEphemeral(true).queue();
        }
    }
}
