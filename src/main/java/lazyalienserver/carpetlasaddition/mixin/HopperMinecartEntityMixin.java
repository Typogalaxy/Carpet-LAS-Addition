package lazyalienserver.carpetlasaddition.mixin;

import lazyalienserver.carpetlasaddition.CarpetLASSetting;
import net.minecraft.entity.vehicle.HopperMinecartEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HopperMinecartEntity.class)
public abstract class HopperMinecartEntityMixin {
    @Redirect(method = "dropItems",at=@At(value = "INVOKE",target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z"))
    public boolean getBoolean(GameRules instance, GameRules.Key<GameRules.BooleanRule> rule) {
        if(CarpetLASSetting.MinecartDropModify){
            return false;
        }
        return instance.get(rule).get();
    }
}
