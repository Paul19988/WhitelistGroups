package uk.co.paulcodes.groups.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.paulcodes.groups.Groups;

public class SWhitelistCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("swhitelist")) {
            if(args.length < 2) {
                sender.sendMessage("Usage: /swhitelist <group> <true/false>");
                return true;
            }

            if(args.length == 2) {
                if(args[1].equalsIgnoreCase("true")) {
                    if(args[0].equalsIgnoreCase("gizzy")) {
                        Groups.getInstance().setGizzy(true);
                        sender.sendMessage("Gizzy is now whitelisted.");
                    }else if(args[0].equalsIgnoreCase("slime")) {
                        Groups.getInstance().setSlime(true);
                        sender.sendMessage("Slime is now whitelisted.");
                    }
                }else if(args[1].equalsIgnoreCase("false")) {
                    if(args[0].equalsIgnoreCase("gizzy")) {
                        Groups.getInstance().setGizzy(false);
                        sender.sendMessage("Gizzy is now not whitelisted.");
                    }else if(args[0].equalsIgnoreCase("slime")) {
                        Groups.getInstance().setSlime(false);
                        sender.sendMessage("Slime is now not whitelisted.");
                    }
                }
            }
        }
        return false;
    }

}
