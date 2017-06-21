package me.rtn.poseidon.bungee.commands;/*
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

import me.rtn.poseidon.general.MessageFormattings;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class MessageCommand extends Command {
    public MessageCommand() {
        super("msg", "network.bungeecommands.msg", "msg");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length == 0){
                player.sendMessage(MessageFormattings.BUNGEE_MESSAGE_INVALID_MESSAGE);
                return;
            }
            String targetPlayer = args[0];
            if(ProxyServer.getInstance().getPlayer(targetPlayer) == null){
                player.sendMessage(MessageFormattings.BUNGEE_PLAYER_OFFLINE);
                return;
            }
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetPlayer);
            if(checkForNullArgs(args, 1)){
                player.sendMessage(MessageFormattings.BUNGEE_MESSAGE_INVALID_MESSAGE);
                return;
            }
            String message = "";
            for(int x = 1; x < args.length; x++){
                if(message.equals("")){
                    message = args[x];
                } else {
                    message = message +  " " + args[x];
                }
            }
            target.sendMessage(MessageFormattings.BUNGEE_MESSAGE_FORMAT + message);
        }
    }

    private boolean checkForNullArgs(String[] args, int index){
        try {
            String temp = args[index];
            return false;
        } catch (IndexOutOfBoundsException ex){
            return true;
        }
    }
}
