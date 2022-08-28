package com.badbones69.crazycrates.support.utils

import net.md_5.bungee.api.ChatColor
import java.util.regex.Matcher
import java.util.regex.Pattern

fun color(message: String): String {
    val hexPattern = Pattern.compile("#([A-Fa-f0-9]){6}")
    val matcher: Matcher = hexPattern.matcher(message)
    val buffer = StringBuffer()

    while (matcher.find()) {
        matcher.appendReplacement(buffer, ChatColor.of(matcher.group()).toString())
    }

    return org.bukkit.ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString())
}