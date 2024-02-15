package me.skythebuilder.fastcrystal;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class FastCrystal extends JavaPlugin implements Listener, CommandExecutor {
    private boolean fastCrystalEnabled = true;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("fastcrystal").setExecutor(this); 
        getLogger().info("CrystalPlugin aktiviert!");
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType() == Material.END_CRYSTAL && fastCrystalEnabled) {

            event.setCancelled(true);


            ItemStack placedCrystal = new ItemStack(Material.END_CRYSTAL, 1);
            event.getPlayer().getInventory().addItem(placedCrystal);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.END_CRYSTAL && fastCrystalEnabled) {

            event.setCancelled(true);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fastcrystal")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                fastCrystalEnabled = !fastCrystalEnabled;
                String status = fastCrystalEnabled ? "§4§lenabled" : "§e§ldisabled";
                player.sendMessage("§bFast Crystal is " + status + ".");
            }
            return true;
        }
        return false;
    }
}
