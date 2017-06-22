package me.rtn.poseidon.spigot.listeners;/*
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

import me.rtn.poseidon.bungee.Proxy;
import me.rtn.poseidon.general.packets.ActionBar;
import me.rtn.poseidon.general.packets.Title;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Title.sendTitle(player, ChatColor.BLUE + "Welcome to the Poseidon network!");
        ActionBar.sendActionBar(player, ChatColor.GREEN + "You are on " + Proxy.getProxyInstance() + "!");
    }
}
