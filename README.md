
This Bukkit plugin, named "FastCrystal," manages the placement and destruction of End Crystals in Minecraft

It listens for block placement and block break events, specifically for the End Crystal (END_CRYSTAL).

When a player attempts to place an End Crystal and "fastCrystalEnabled" is set to true, the placement is canceled, and the plugin gives the player an End Crystal in their inventory.

When a player attempts to break an End Crystal and "fastCrystalEnabled" is true, the destruction is prevented.

The plugin registers the "/fastcrystal" command, allowing players to toggle the "fastCrystalEnabled" variable, providing feedback on the current status.
