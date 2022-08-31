package com.kuri0.rawinput;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.MouseHelper;

public class ToggleCommand extends CommandBase {
    @Override
    public String getName() {
        return "rawinput";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "Toggles Raw Input (/rawinput)";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (Minecraft.getMinecraft().mouseHelper instanceof RawMouseHelper) {
            Minecraft.getMinecraft().mouseHelper = new MouseHelper();
            sender.sendMessage(new TextComponentString("Toggled OFF"));
        } else {
            Minecraft.getMinecraft().mouseHelper = new RawMouseHelper();
            sender.sendMessage(new TextComponentString("Toggled ON"));
        }
    }
    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
