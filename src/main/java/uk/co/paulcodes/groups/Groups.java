package uk.co.paulcodes.groups;

import org.bukkit.plugin.java.JavaPlugin;
import uk.co.paulcodes.groups.commands.GWhitelistCommand;
import uk.co.paulcodes.groups.commands.SWhitelistCommand;
import uk.co.paulcodes.groups.listeners.PlayerListener;

import java.util.UUID;

public class Groups extends JavaPlugin {

    private boolean isGizzy = false;
    private boolean isSlime = false;

    private static Groups instance;

    @Override
    public void onEnable() {
        instance = this;
        if(!getConfig().isList("gizzy")) {
            getConfig().set("gizzy", "Paul19988");
            saveConfig();
        }

        if(!getConfig().isList("slime")) {
            getConfig().set("slime", "Paul19988");
            saveConfig();
        }

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        getServer().getPluginCommand("gwhitelist").setExecutor(new GWhitelistCommand());
        getServer().getPluginCommand("swhitelist").setExecutor(new SWhitelistCommand());
    }

    @Override
    public void onDisable() {

    }

    public boolean isWhitelisted(String group, UUID uuid, String name) {
        if(getConfig().isList(group)) {
            for(String s : getConfig().getStringList(group)) {
                if(s.equalsIgnoreCase(uuid.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addWhitelist(String group, UUID uuid, String name) {
        if(getConfig().isList(group)) {
            getConfig().set(group, uuid.toString());
        }
    }

    public void removeWhitelist(String group, UUID uuid, String name) {
        if(getConfig().isList(group)) {
            getConfig().getStringList(group).add(uuid.toString());
        }
    }

    public boolean isGizzy() {
        return isGizzy;
    }

    public boolean isSlime() {
        return isSlime;
    }

    public void setGizzy(boolean gizzy) {
        isGizzy = gizzy;
    }

    public void setSlime(boolean slime) {
        isSlime = slime;
    }

    // Get instance of the plugin
    public static Groups getInstance() {
        return instance;
    }
}
