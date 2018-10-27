package com.github.blarosen95.alternativeunban.Commands;

import com.github.blarosen95.alternativeunban.AlternativeUnban;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnbanName implements CommandExecutor {

    private AlternativeUnban instance = AlternativeUnban.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("AltPardon")) {
            if (!sender.hasPermission("essentials.unban")) {
                // TODO: 10/27/2018 tell them NO.
                sender.sendMessage(ChatColor.RED + "You don't have the required permissions to do this.");
                return true;
            } else {
                if (args.length != 1) {
                    sender.sendMessage(ChatColor.RED + "You need to provide one, single username to unban.");
                    return true;
                } else {
                    // TODO: 10/27/2018 unban the player.
                    if (instance.testing(args[0])) {
                        sender.sendMessage(String.format(ChatColor.GREEN + "%s was successfully unbanned!", args[0]));
                    } else {
                        sender.sendMessage(String.format(ChatColor.RED + "%s was NOT unbanned successfully. Are you sure that they have an existing ban with that username?", args[0]));
                    }

                    return true;
                }
            }

        } else if (!(sender instanceof Player)) {
            // TODO: 10/27/2018 try to unban the player, console has assumed privilege here.
            if (args.length != 1) {
                System.out.println("You need to provide one, single username to unban.");
                return true;
            } else {
                if (instance.testing(args[0])) {
                    System.out.println(String.format("%s was successfully unbanned!", args[0]));
                } else {
                    System.out.println(String.format("%s was not successfully unbanned. Are you sure that they have an existing ban with that username?", args[0]));
                }
            }
            return true;
        }

        return true;
    }

}