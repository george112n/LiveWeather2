package aplugin.Commands;
import java.time.LocalTime;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aplugin.WeatherPreference;

/**
 * @author 14walkerg
 * @date 3 Jan 2021
 * @time 14:08:09
 */

public class LiveTime implements CommandExecutor
{
	public static void main(String[] args)
	{
		//Declare Variables

	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		//Check is command sender is a player
		if (!(sender instanceof Player))
		{
			sender.sendMessage("&cYou cannot add a player to a region!");
			return true;
		}
		
		//Convert sender to player
		Player p = (Player) sender;
		
		//Initiate player preferences
		WeatherPreference wp = new WeatherPreference();

		//Sets the UUID into the wp class
		wp.setUUID(p.getUniqueId().toString());
		
		//Gets weather preferences
		wp.fetchFromUUID();
		
		wp.toogleTime();
		
		return true;
	}
}
//End Class

//Created by Bluecarpet in London