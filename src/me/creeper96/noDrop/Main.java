package me.creeper96.noDrop;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.mewin.WGCustomFlags.WGCustomFlagsPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.RegionGroup;
import com.sk89q.worldguard.protection.flags.StateFlag;

/*    */ 
/*    */ 
/*    */ public class Main extends JavaPlugin
/*    */ {
/* 34 */  
/*    */   


		   public static StateFlag NO_EXP = new StateFlag("non-dare-exp", true, RegionGroup.ALL);
		   public static StateFlag NO_DROP = new StateFlag("non-dare-drop", true, RegionGroup.ALL);


		   public static WorldGuardPlugin wgPlugin;
/*    */   public static WGCustomFlagsPlugin custPlugin;
/*    */   private Eventi listener;
/*    */ 
/*    */   public void onEnable()
/*    */   {
/* 47 */     Main.wgPlugin = getWorldGuard();
/* 48 */     Main.custPlugin = getWGCustomFlags();
/* 49 */     this.listener = new Eventi();
/*    */ 
/* 51 */     if (wgPlugin == null) {
/* 52 */       getLogger().warning("This plugin requires WorldGuard, disabling.");
/* 53 */       getServer().getPluginManager().disablePlugin(this);
/* 54 */       return;
/*    */     }
/*    */ 
/* 57 */     if (custPlugin == null) {
/* 58 */       getLogger().warning("This plugin requires WorldGuard Custom Flags, disabling.");
/* 59 */       getServer().getPluginManager().disablePlugin(this);
/* 60 */       return;
/*    */     }
/*    */ 
/* 63 */     getServer().getPluginManager().registerEvents(this.listener, this);
/*    */ 

			 custPlugin.addCustomFlag(NO_DROP);
			 custPlugin.addCustomFlag(NO_EXP);
/*    */   }
/*    */ 
/*    */   private WorldGuardPlugin getWorldGuard()
/*    */   {
/* 74 */     Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
/*    */ 
/* 76 */     if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
/* 77 */       return null;
/*    */     }
/*    */ 
/* 80 */     return ((WorldGuardPlugin)plugin);
/*    */   }
/*    */ 
/*    */   private WGCustomFlagsPlugin getWGCustomFlags()
/*    */   {
/* 85 */     Plugin plugin = getServer().getPluginManager().getPlugin("WGCustomFlags");
/*    */ 
/* 87 */     if ((plugin == null) || (!(plugin instanceof WGCustomFlagsPlugin))) {
/* 88 */       return null;
/*    */     }
/*    */ 
/* 91 */     return ((WGCustomFlagsPlugin)plugin);
/*    */   }
		}