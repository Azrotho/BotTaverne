package fr.azrotho.taverne;

import fr.azrotho.taverne.events.OnButton;
import fr.azrotho.taverne.events.OnCommand;
import fr.azrotho.taverne.events.OnMessage;
import fr.azrotho.taverne.utils.ManageLoadSave;
import fr.azrotho.taverne.objects.Players;
import fr.azrotho.taverne.utils.Token;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

public class Main {


    public static Main INSTANCE;

    public static List<Players> players = new ArrayList<Players>();
    private static HashMap<String, Integer> cooldownMessage = new HashMap<String, Integer>();

    public static JDA jda;

    public static void main(String[] args) {

        ManageLoadSave.load();


        JDA jda = JDABuilder.createLight(Token.tokens, EnumSet.allOf(GatewayIntent.class)) // slash commands don't need any intents
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.streaming("sur twitch.tv/azrotho", "https://www.twitch.tv/azrotho")) // Display activity
                .addEventListeners(new OnCommand())
                .addEventListeners(new OnButton())
                .addEventListeners(new OnMessage())
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_MESSAGES)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();



        CommandListUpdateAction commands = jda.updateCommands();

       commands.addCommands(
                Commands.slash("ping", "Pong !")
        );

       commands.addCommands(
                Commands.slash("miaou", "Miaou !")
        );

        commands.addCommands(
        Commands.slash("sondage", "Cr??er un sondage")
                .addOption(OptionType.STRING, "question", "La question du sondage", true)
                .addOption(OptionType.STRING, "r??ponse1", "La premi??re r??ponse", true)
                .addOption(OptionType.STRING, "r??ponse2", "La deuxi??me r??ponse", true)
                .addOption(OptionType.STRING, "r??ponse3", "La troisi??me r??ponse", false)
                .addOption(OptionType.STRING, "r??ponse4", "La quatri??me r??ponse", false)
                );

        commands.addCommands(
                Commands.slash("warn", "Warn un utilisateur")
                        .addOption(OptionType.USER, "user", "L'utilisateur ?? warn", true)
                        .addOption(OptionType.STRING, "reason", "La raison du warn", true)
        );

        commands.addCommands(
                Commands.slash("clear", "Clear un nombre de messages")
                        .addOption(OptionType.INTEGER, "nombre", "Le nombre de messages ?? clear", true)
        );

        commands.addCommands(
                Commands.slash("youtube", "Affiche la cha??ne Youtube")
        );

        commands.addCommands(
                Commands.slash("twitch", "Affiche la cha??ne Twitch")
        );

        commands.addCommands(
                Commands.slash("youtubevod", "Affiche la cha??ne Youtube VOD")
        );

        commands.addCommands(
                Commands.slash("tiktok", "Affiche le compte Tiktok")
        );

        commands.addCommands(
                Commands.slash("wishlist", "Affiche ma liste de souhait")
        );

       commands.addCommands(
                Commands.slash("sendrole", "Envoie le r??le")
        );
        commands.addCommands(
                Commands.slash("giverole", "Donne le role ?? tous le monde")
                        .addOption(OptionType.ROLE, "role", "Le r??le ?? donner", true)
        );
        commands.addCommands(
                Commands.slash("say", "Fait dire quelque chose au bot")
                        .addOption(OptionType.STRING, "message", "Le message ?? faire dire au bot", true)
        );
        commands.addCommands(
                Commands.slash("reply", "R??pond ?? un message")
                        .addOption(OptionType.STRING, "message", "Le message ?? faire dire au bot", true)
                        .addOption(OptionType.STRING, "id", "L'id du message ?? r??pondre", true)
        );

        commands.addCommands(
                Commands.slash("senddm", "Envoie un message en DM")
                        .addOption(OptionType.USER, "user", "L'utilisateur ?? qui envoyer le message", true)
                        .addOption(OptionType.STRING, "message", "Le message ?? envoyer", true)
        );
        commands.addCommands(
                Commands.slash("sendticket", "Envoie un message dans le salon ticket")
        );

        commands.addCommands(
                Commands.slash("sendaddharuki", "Ajouter HARUKI !!!!")
        );

        commands.addCommands(
                Commands.slash("resetxp", "Reset l'XP d'un membre")
                        .addOption(OptionType.USER, "user", "L'utilisateur ?? qui reset l'XP", true)
        );

        commands.addCommands(
                Commands.slash("xp", "Savoir son XP ou celui de quelqu'un d'autre")
                        .addOption(OptionType.USER, "user", "L'utilisateur dont on veut savoir l'XP", false)
        );

        commands.addCommands(
                Commands.slash("leaderboard", "Savoir son niveau ou celui de quelqu'un d'autre")
        );
        commands.queue();




        Thread save = new Thread(() -> {
            while (true) {

                // Get All members


                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ManageLoadSave.save();
            }
        });
        save.start();

        Thread cooldown = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Get All members
                cooldownMessage.replaceAll((k, v) -> v - 1);
                cooldownMessage.entrySet().removeIf(entry -> entry.getValue() <= 0);
            }
        });

        cooldown.start();
    }

    public static HashMap<String, Integer> getCooldownMessage() {
        return cooldownMessage;
    }
}
