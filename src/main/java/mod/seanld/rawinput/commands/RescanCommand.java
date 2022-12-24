package mod.seanld.rawinput.commands;

import mod.seanld.rawinput.RawInputHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class RescanCommand extends CommandBase {
	@Override
	public String getName() {
		return "rescan";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Rescans input devices: /rescan";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		RawInputHandler.rescan();
	}
	@Override
	public int getRequiredPermissionLevel() {
		return -1;
	}
}
