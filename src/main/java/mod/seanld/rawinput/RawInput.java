package mod.seanld.rawinput;

import mod.seanld.rawinput.commands.RescanCommand;
import mod.seanld.rawinput.commands.ToggleCommand;
import mod.seanld.rawinput.keybinds.KeybindHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = RawInput.MODID, version = RawInput.VERSION, name = "Raw Input", useMetadata = true)
public class RawInput
{
    public static final String MODID = "rawinput";
    public static final String VERSION = "1.4.0";

	@SideOnly(Side.CLIENT)
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		ClientCommandHandler.instance.registerCommand(new RescanCommand());
		ClientCommandHandler.instance.registerCommand(new ToggleCommand());
		Minecraft.getMinecraft().mouseHelper = new RawMouseHelper();
		MinecraftForge.EVENT_BUS.register(new KeybindHandler());

		RawInputHandler.init();
    }

	@SideOnly(Side.CLIENT)
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		KeybindHandler.init();
	}
}
