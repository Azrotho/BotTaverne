package fr.azrotho.taverne.events;

import fr.azrotho.taverne.Main;
import fr.azrotho.taverne.objects.Players;
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




        if(!Main.getCooldownMessage().containsKey(event.getAuthor().getId())){

        if (event.getMessage().getContentRaw().length() > 5 && !event.getMember().getRoles().contains(event.getGuild().getRoleById("925340625631584297")) && !event.getAuthor().isBot()) {
            int len = event.getMessage().getContentRaw().length();
            double booster = 1;
            int xp = len / 10 + 1;
            if (xp > 10) {
                xp = 10;
            }
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1048346722092466256"))) {
                booster = 1.2;
            }
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1048351615519838289"))) {
                booster = 1.5;
            }
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1048370427799535708"))) {
                booster = 1.8;
            }
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1048370013582659665"))) {
                booster = 2;
            }
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1048370091068243999"))) {
                booster = 2.5;
            }
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("912027535120932894"))) {
                booster = booster + 0.1;
            }
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1062721389741752444"))) {
                booster = booster + 0.15;
            }

            String id = event.getAuthor().getId();
            // Get Player
            Players player = Main.players.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
            if (player == null) {
                Players newPlayer = new Players(id, xp, 0, event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator());
                Main.players.add(newPlayer);
            } else {
                player.addXp((int) (xp * booster));
                if (XPManager.detectLevelup(event.getAuthor().getId())) {
                    player.setName(event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator());
                    event.getChannel().sendMessage("Bravo <@" + event.getAuthor().getId() + "> tu viens de passer niveau " + player.getLevel() + "!").queue();

                        // C'est pas clean je rangerais plus tard

                    if (player.getLevel() >= 1) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058449839400173651")).queue();
                    }
                    if (player.getLevel() >= 5) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058449952675733685")).queue();
                    }
                    if (player.getLevel() >= 10) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058450077133307924")).queue();
                    }
                    if (player.getLevel() >= 15) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058450241470349403")).queue();
                    }
                    if (player.getLevel() >= 20) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058450362597654620")).queue();
                    }
                    if (player.getLevel() >= 25) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058450473230807110")).queue();
                    }
                    if (player.getLevel() >= 30) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058450581552906282")).queue();
                    }
                    if (player.getLevel() >= 35) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058450587873722448")).queue();
                    }
                    if (player.getLevel() >= 40) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058450886722060398")).queue();
                    }
                    if (player.getLevel() >= 45) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058450977046396928")).queue();
                    }
                    if (player.getLevel() >= 50) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1058451040413954129")).queue();
                        }
                    }
                Main.getCooldownMessage().put(event.getAuthor().getId(), (int) (Math.random() * 90) + 30);
                }
            }
        }
    }
}
