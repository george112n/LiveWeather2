
/**
 * @author 14walkerg
 * @date 3 Jan 2021
 * @time 23:37:13
 */
package aplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aplugin.WeatherPreference;

public class LiveWeather implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		//Check is command sender is a player
		if (!(sender instanceof Player)) {
			sender.sendMessage("&cYou cannot add a player to a region!");
			return true;
		}

		//Convert sender to player
		Player p = (Player) sender;
		
		//Initiate player preferences
		WeatherPreference wp = new WeatherPreference();
		
		if (args.length > 1)
		{
			p.sendMessage(ChatColor.RED + "/liveweather [Fog]");
			return true;
		}
		
		//Get player's preferences
		else 
		{
			//Sets the UUID into the wp class
			wp.setUUID(p.getUniqueId().toString());
			
			//Gets weather preferences
			wp.fetchFromUUID();
		}
		
		//Used for toggling live weather on and off
		if (args.length == 0)
		{
			//Fog is turned off withing function if weather is turned off
			wp.toogleWeather();
		}
		
		//Used for toggling live fog on and off
		else if (args[0].equalsIgnoreCase("fog"))
			wp.toogleFog();

		return true;
	}
}
//End Class

//Created by Bluecarpet in London