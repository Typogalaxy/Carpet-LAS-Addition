package lazyalienserver.carpetlasaddition.commands.Client;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import lazyalienserver.carpetlasaddition.screen.CalcPearlScreen;
import net.minecraft.client.MinecraftClient;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
public class CalcPearlCommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher){
        dispatcher.register(literal("CalcPearl").executes(context -> setScreen(context.getSource().getClient())));
    }
    private static int setScreen(MinecraftClient client){
        client.setScreen(new CalcPearlScreen());
        return Command.SINGLE_SUCCESS;
    }
}
