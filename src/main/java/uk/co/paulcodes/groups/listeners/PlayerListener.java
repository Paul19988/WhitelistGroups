package uk.co.paulcodes.groups.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import uk.co.paulcodes.groups.Groups;

import java.util.UUID;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerPreJoin(AsyncPlayerPreLoginEvent event) {
        UUID uuid = event.getUniqueId();
        String name = event.getName();
        if(Groups.getInstance().isGizzy()) {
            if(!Groups.getInstance().isWhitelisted("gizzy", uuid, name)) {
                event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, "You are not permitted to enter during this recording!");
            }
        }

        if(Groups.getInstance().isSlime()) {
            if(!Groups.getInstance().isWhitelisted("gizzy", uuid, name)) {
                event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, "You are not permitted to enter during this recording!");
            }
        }
    }

}
