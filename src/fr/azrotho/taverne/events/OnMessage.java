package fr.azrotho.taverne.events;

import fr.azrotho.taverne.Main;
import fr.azrotho.taverne.utils.XPManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class OnMessage extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        System.out.println(event.getMessage().getContentRaw());
        if (event.getMessage().getContentRaw().equalsIgnoreCase("feur")) {
            event.getMessage().reply("ouge").queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("miaou")) {
            event.getMessage().reply("Miaou à toi mon frère").queue();
        }
        if(event.getMessage().getContentRaw().contains("<@1038130575959142423>")) {
            event.getMessage().reply("Bonjour je suis Raphael le gentil robot *(donnez moi une liste de phrase à dire)*").queue();
        }
        if(event.getMessage().getContentRaw().contains("<@1048696324914171914>")) {
            event.getChannel().sendMessage("Haruki est un Bot Discord développé par le Grand Azrotho, C'est un bot de jeu qui sera en ligne le 31 Janvier 2023 ! *(Préparez-vous!)*").setActionRow(Button.link("https://discord.com/oauth2/authorize?client_id=1048696324914171914&permissions=8&scope=bot%20applications.commands", "Ajouter Haruki")).queue();
        }
        if(event.getMessage().getContentRaw().contains("Haruki")){
            event.getMessage().reply("Haruki est un Bot Discord développé par le Grand Azrotho, C'est un bot de jeu qui sera en ligne le 31 Janvier 2023 ! *(Préparez-vous!)*").setActionRow(Button.link("https://discord.com/oauth2/authorize?client_id=1048696324914171914&permissions=8&scope=bot%20applications.commands", "Ajouter Haruki")).queue();
        }

        Main.getUserById().put(event.getAuthor().getId(), event.getAuthor());



//        if (event.getMessage().getContentRaw().length() > 5 && !event.getMember().getRoles().contains(event.getGuild().getRoleById("925340625631584297")) && !event.getAuthor().isBot()) {
//            int len = event.getMessage().getContentRaw().length();
//            double booster = 1;
//            int xp = len / 10 + 1;
//            if (xp > 10) {
//                xp = 10;
//            }
//            if(event.getMember().getRoles().contains(event.getGuild().getRoleById("1048346722092466256"))){
//                booster = 1.2;
//            }
//            if(event.getMember().getRoles().contains(event.getGuild().getRoleById("1048351615519838289"))){
//                booster = 1.5;
//            }
//            if(event.getMember().getRoles().contains(event.getGuild().getRoleById("1048370427799535708"))){
//                booster = 1.8;
//            }
//            if(event.getMember().getRoles().contains(event.getGuild().getRoleById("1048370013582659665"))){
//                booster = 2;
//            }
//            if(event.getMember().getRoles().contains(event.getGuild().getRoleById("1048370091068243999"))){
//                booster = 2.5;
//            }
//            String id = event.getAuthor().getId();
//            XPManager.addXP(id, (long) (xp*booster));
//        }
    }
}
