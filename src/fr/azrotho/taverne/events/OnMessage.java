package fr.azrotho.taverne.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OnMessage extends ListenerAdapter {

// if someone say "feur", the bot replay "ouge"
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equalsIgnoreCase("feur")) {
            event.getChannel().sendMessage("ouge").queue();
        }
    }
}
