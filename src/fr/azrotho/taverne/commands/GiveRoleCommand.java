package fr.azrotho.taverne.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class GiveRoleCommand {
    public static void giveRole(Guild guild, Role role) {
        List<Member> members = guild.getMembers();
        for (Member member : members) {
            guild.addRoleToMember(member, role).queue();
        }
    }
}
