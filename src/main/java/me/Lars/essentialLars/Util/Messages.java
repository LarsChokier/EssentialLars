package me.Lars.essentialLars.Util;

import org.bukkit.ChatColor;

public final class Messages {

    private static final ChatColor POSITIVE_COLOR = ChatColor.AQUA;

    private Messages() {
    }

    public static String error(String text) {
        return ChatColor.RED + "error >> " + ChatColor.GRAY + text;
    }

    public static String positive(String text) {
        return POSITIVE_COLOR + "ok >> " + ChatColor.GRAY + text;
    }
}
