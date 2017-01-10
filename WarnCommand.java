package net.Pixelors.warn;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarnCommand implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Object getCommand(String string) {
		
		return null;
	}

	private Warnings plugin;
	
	public WarnCommand(Warnings main) {
		this.plugin = main;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
		Player p = (Player) sender;
		if(p.hasPermission("warn.see.warning")) {
			
		if(cmd.getName().equalsIgnoreCase("mywarnings")) {
		if(args.length == 0) {
			int warns = plugin.getConfig().getInt("warns." + p.getName());
		p.sendMessage("§4§lWarn> §7You have got " + warns + " §7warns!");
		}
			if(p.hasPermission("warn.issue.warning"){
			if(cmd.getName().equalsIgnoreCase("warn"){
				if(args.length == 0) {
					p.sendMessage("§4§lWarn> §a/warn <player> <reason>");
				
				
		
		} else if(args.length == 1) {
			p.sendMessage("§4§lWarn> §7Please provide a warning reason!");
		
		}else if(args.length >= 2) {
			
			String msg = "";
			Player target = Bukkit.getServer().getPlayer(args[0]);
			
			if(target != null) {
				
				for(int i = 1; i < args.length; i++) {
					msg = msg + args[i] + " ";
				}
				
				int warns = plugin.getConfig().getInt("warns." + target.getName());
				
				
				
				
				if(warns == 0) {
					plugin.getConfig().set("warns." + target.getName(), 1);
					p.sendMessage("§4§lWarn> §7You warned §e" + target.getName() + "§7!");
					target.kickPlayer("§4§lWarn> §7You have been warned! §eReason: \n" + msg);
					
					
					
				}else if(warns == 1) {
					plugin.getConfig().set("warns." + target.getName(), 2);
					target.kickPlayer("§4§lWarn> §7You have been warned! §eReason: \n" 
					+ msg);
					p.sendMessage("§4§lWarn> §7You warned §e" + target.getName() + "§7 because of " + msg + "§7!");
					
				}else if(warns == 2) {
					plugin.getConfig().set("warns." + target.getName(), 0);
					target.setBanned(true);;
					target.kickPlayer("§4§lWarn> §7You have been banned! §eReason: \n"
					+ msg
					+ "§7If you feel you have been punished wrong please appeal at pixelors.net ");
					
					p.sendMessage("§4§lWarn> §7You warned §e" + target.getName() + "§7! Because the player had 2 warns already the player got banned!");
				}
				
			}else{
				p.sendMessage("§4§lWarn> §7This player is not online!");
			}
		} else {
			p.sendMessage("§4§lWarn> §7/warn <player> <reason>");
		}
		
			
			}
		
		} else {
			if(!p.hasPermission("warn.issue.warning")) {
				p.sendMessage("§4§lWarn> §7This requires Network-Rank [§6§lMOD§7]");
			}
			
		}
		
		
		return true;
		}


		return false;
}
}
