package me.daansander.reporter;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Daan on 20-4-2015.
 */
public class ReportCommand extends Command {

    public ReportCommand() {
        super("report");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if(args.length >= 2) {
            ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
            if(player == null) {
                TextComponent c = new TextComponent("Could not find player " + args[0] + " on this network");
                c.setColor(ChatColor.RED);
                c.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(args[0]).create()));
                p.sendMessage(c);
                return;
            }
            ArrayList<String> r = new ArrayList<>(Arrays.asList(args));

            r.remove(0);
            String reason = "";
            for(String s : r) {
                System.out.println("ArrayList informatie " + s);
                reason = reason + " " + s;
            }
            System.out.println(args.toString());
            reason = reason.trim();
            System.out.println(reason);
            Report report = new Report(p.getName(), player.getName(), reason, new Date());
            p.sendMessage(new TextComponent("Reported: " + report.getReported()));
            return;
        }
    }

}
