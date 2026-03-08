package net.hanhai.titankillerneo.util;

import net.minecraft.ChatFormatting;

public class Color {
    private static final ChatFormatting[] colour = new ChatFormatting[] {
            ChatFormatting.RED, ChatFormatting.GOLD, ChatFormatting.YELLOW, ChatFormatting.GREEN, ChatFormatting.AQUA, ChatFormatting.BLUE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.DARK_AQUA, ChatFormatting.DARK_BLUE, ChatFormatting.DARK_GRAY,
            ChatFormatting.DARK_GREEN, ChatFormatting.DARK_PURPLE, ChatFormatting.DARK_RED};

    public static String formatting(String input, ChatFormatting[] colours, double delay) {
        StringBuilder sb = new StringBuilder(input.length() * 3);
        if (delay <= 0.0D)
            delay = 0.001D;
        int offset = (int)Math.floor((System.currentTimeMillis() & 0x3FFFL) / delay) % colours.length;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sb.append(colours[(colours.length + i - offset) % colours.length].toString());
            sb.append(c);
        }
        return sb.toString();
    }

    public static String makeColour(String input) {
        return formatting(input, colour, 80.0D);
    }

    public static String makeColour2(String input) {
        return formatting(input, colour, 59.5D);
    }
}
