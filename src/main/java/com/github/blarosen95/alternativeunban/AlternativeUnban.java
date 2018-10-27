package com.github.blarosen95.alternativeunban;

import com.github.blarosen95.alternativeunban.Commands.UnbanName;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public final class AlternativeUnban extends JavaPlugin {

    private static AlternativeUnban instance;

    public static AlternativeUnban getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.getCommand("altpardon").setExecutor(new UnbanName());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public boolean testing(String targetArg) {
        Set<BanEntry> banEntries = getServer().getBanList(BanList.Type.NAME).getBanEntries();
        for (BanEntry banEntry : banEntries) {
            if (banEntry.getTarget().equalsIgnoreCase(targetArg)) {
                getServer().getBanList(BanList.Type.NAME).pardon(targetArg);
                return true;
            }
        }
        return false;
    }

}
