package me.koutachan.specialitem

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import me.koutachan.specialitem.coreprotectAPI.CoreprotectAPI
import org.bukkit.inventory.EquipmentSlot

object Event : Listener {
    @EventHandler
    fun onPlayerBlockPlaceEvent(e: BlockPlaceEvent) {
        if (e.block.type == Material.FARMLAND && e.player.isSneaking) {
            if ((e.hand == EquipmentSlot.HAND && e.player.inventory.itemInMainHand.itemMeta?.displayName.equals("${ChatColor.GREEN}強化されたクワ")) || (e.hand == EquipmentSlot.OFF_HAND && e.player.inventory.itemInOffHand.itemMeta?.displayName.equals("${ChatColor.GREEN}強化されたクワ"))) {
                for (x in -1..1) {
                    for (z in -1..1) {
                        val a = e.block.location.add(x.toDouble(), 0.0, z.toDouble())
                        if(a.block.type == Material.GRASS_BLOCK || a.block.type == Material.DIRT) {
                            val airCheck = e.block.location.add(x.toDouble(), 1.0 , z.toDouble())
                            if (airCheck.block.type == Material.AIR || airCheck.block.type == Material.CAVE_AIR) {

                                e.player.playSound(e.player.location, Sound.ITEM_HOE_TILL, 1F, 1F)
                                CoreprotectAPI.apiCoreProtect()?.logRemoval(e.player.name, a.block.location, a.block.type, a.block.blockData)

                                a.block.type = Material.FARMLAND

                                CoreprotectAPI.apiCoreProtect()?.logPlacement(e.player.name, a.block.location, Material.FARMLAND, a.block.blockData)
                            }
                        }
                    }
                }
            }
        }
    }
}