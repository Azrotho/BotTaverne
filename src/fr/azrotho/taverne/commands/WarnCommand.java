package fr.azrotho.taverne.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class WarnCommand {
    public static void warnUser(TextChannel channel, Member member, User user, String reason) {
        channel.sendMessage("L'utilisateur " + user.getAsMention() + " vous avez été averti pour: " + reason).queue();
        Guild guild = member.getGuild();
        if(member.getRoles().contains(guild.getRoleById("1038197508100333700"))){
            if(member.getRoles().contains(guild.getRoleById("1038197646860488778"))){
                member.kick().queue();
            }else{
                guild.addRoleToMember(member, guild.getRoleById("1038197646860488778")).queue();
            }
        }else{
            guild.addRoleToMember(member, guild.getRoleById("1038197508100333700")).queue();;
        }
    }
}