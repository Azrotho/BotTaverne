package fr.azrotho.taverne.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OnMessage extends ListenerAdapter {

// if someone say "feur", the bot replay "ouge"
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
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
    }
}
