package me.creeper96.noDrop;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;


public class Eventi implements Listener{


	@EventHandler
	public void MobMorte(EntityDeathEvent e)
	{
		if(Main.wgPlugin.getGlobalRegionManager().allows(Main.NO_DROP, e.getEntity().getLocation()))
		{

			e.getDrops().clear();		
		}
		else
		if(Main.wgPlugin.getGlobalRegionManager().allows(Main.NO_DROP, e.getEntity().getLocation()))
		{

			e.setDroppedExp(0);
			Player p = e.getEntity().getKiller();
			
		}		

	}
	
	
	
	@EventHandler
	public void RiceviExp(PlayerExpChangeEvent e)
	{
		if(Main.wgPlugin.getGlobalRegionManager().allows(Main.NO_EXP, e.getPlayer().getLocation()))
		{

			e.setAmount(0);
			
		}	
	}
}
