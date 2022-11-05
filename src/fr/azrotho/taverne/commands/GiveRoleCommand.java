package fr.azrotho.taverne.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class GiveRoleCommand {
    public static void giveRole(Guild guild, Role role) {
        for(Member member : guild.getMemberCache()){
            System.out.println(member.getNickname());
                guild.addRoleToMember(member, role).queue();
        }
    }
}
