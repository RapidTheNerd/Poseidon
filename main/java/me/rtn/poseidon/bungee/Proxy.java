package me.rtn.poseidon.bungee;/*
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

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Proxy extends Plugin implements Listener {

    private static Proxy proxyInstance;

    @Override
    public void onEnable(){
        proxyInstance = this;
    }
    @Override
    public void onDisable(){
        proxyInstance = this;
    }

    public static Proxy getProxyInstance() {
        return proxyInstance;
    }
}
