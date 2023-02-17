package uk.co.paulcodes.groups.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.paulcodes.groups.Groups;

public class GWhitelistCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("gwhitelist")) {
            if(sender.hasPermission("whitelistgroups.gizzy")) {
                if(args.length == 0) {
                    sender.sendMessage("Usage: /gwhitelist <add/remove> <group> <player>");
                    return true;
                }
                if(args[0].equalsIgnoreCase("add")) {
                    if(args.length == 1) {
                        sender.sendMessage("Usage: /gwhitelist add <group> <player>");
                    }
                    if(Bukkit.getPlayer(args[2]) != null) {
                        Groups.getInstance().addWhitelist(args[1], Bukkit.getPlayer(args[2]).getUniqueId(), Bukkit.getPlayer(args[2]).getName());
                        sender.sendMessage("Added " + Bukkit.getPlayer(args[2]).getName() + " to the " + args[1] + " whitelist.");
                    }else{
                        sender.sendMessage("Player not found.");
                    }
                }else if(args[0].equalsIgnoreCase("remove")) {
                    if(args.length == 1) {
                        sender.sendMessage("Usage: /gwhitelist remove <group> <player>");
                    }
                    if(Bukkit.getPlayer(args[2]) != null) {
                        Groups.getInstance().removeWhitelist(args[1], Bukkit.getPlayer(args[2]).getUniqueId(), Bukkit.getPlayer(args[2]).getName());
                        sender.sendMessage("Removed " + Bukkit.getPlayer(args[2]).getName() + " from the " + args[1] + " whitelist.");
                    }else{
                        sender.sendMessage("Player not found.");
                    }
                }

            }
        }
        return false;
    }

}
