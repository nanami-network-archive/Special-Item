package me.koutachan.specialitem

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin

class SpecialItem : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }
    override fun onEnable() {
        plugin = this
        val recipe1Item = ItemStack(Material.DIAMOND_HOE)
        val recipe1Meta = recipe1Item.itemMeta
        recipe1Meta?.setDisplayName("${ChatColor.GREEN}強化されたクワ")
        recipe1Meta?.lore = mutableListOf("${ChatColor.YELLOW}シフトをして耕すことで3x3のエリアを耕せる","${ChatColor.RED}このアイテムをアンビルで使わないでください、使用不可能になります。")
        recipe1Item.itemMeta = recipe1Meta

        val recipe1 = ShapedRecipe(NamespacedKey(this,"diamond_hoe"), recipe1Item)
        recipe1.shape("DD "," S "," S ")
        recipe1.setIngredient('D', Material.DIAMOND_BLOCK)
        recipe1.setIngredient('S', Material.STICK)
        Bukkit.addRecipe(recipe1)

        server.pluginManager.registerEvents(Event,this)
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}