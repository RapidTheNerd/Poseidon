package me.rtn.poseidon.spigot.managers;/*
 * Jump
 * Copyright (C) 2017 RapidTheNerd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import me.rtn.poseidon.spigot.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhitelistManager implements Listener {

    @EventHandler
    private void checkPlayerAccess(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        try {
            searchForUUID(player.getUniqueId().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void searchForUUID(String playerUUID) throws FileNotFoundException {

        final Scanner scanner = new Scanner("whitelisted-users.txt");
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();
            if (lineFromFile.contains(playerUUID)) {
               allowAccess();
            } else if(!lineFromFile.contains(playerUUID)){
                denyAccess();
            }
        }
    }
    private void denyAccess(){
        Player player = (Player) Main.getSpigotInstance().getServer().getOnlinePlayers();
        player.kickPlayer("You do not have access to join this server");
    }
    private void allowAccess(){
        Player player = (Player) Main.getSpigotInstance().getServer().getOnlinePlayers();
        player.setWhitelisted(true);
    }
}

