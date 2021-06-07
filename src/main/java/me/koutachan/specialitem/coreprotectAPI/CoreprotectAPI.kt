package me.koutachan.specialitem.coreprotectAPI

import net.coreprotect.CoreProtect
import net.coreprotect.CoreProtectAPI
import org.bukkit.Bukkit.getServer

object CoreprotectAPI {
    fun apiCoreProtect(): CoreProtectAPI? {

        // https://www.minerealm.com/community/viewtopic.php?f=32&t=16687

        val plugin = getServer().pluginManager.getPlugin("CoreProtect")

        // Check that CoreProtect is loaded
        if (plugin == null || plugin !is CoreProtect) {
            return null
        }

        // Check that the API is enabled
        val coreprotect = plugin.api
        if (!coreprotect.isEnabled) {
            return null
        }

        // Check that a compatible version of the API is loaded
        if (coreprotect.APIVersion() < 6) {
            return null
        }

        return coreprotect
    }
}