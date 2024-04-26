package com.suppergerrie2.autof5.mixin;

import com.suppergerrie2.autof5.AutoF5;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Unique
    private static Perspective previousPerspective;

    @Inject(at = @At("TAIL"), method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z")
    private void startRiding(Entity entity, boolean force, CallbackInfoReturnable<Boolean> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (((Object) this) instanceof PlayerEntity e && e.getWorld().isClient() && e == client.player) {
            previousPerspective = client.options.getPerspective();
            client.options.setPerspective(AutoF5.CONFIG.defaultVehiclePerspective().getPerspective(previousPerspective));
        }
    }

    @Inject(at = @At("HEAD"), method = "stopRiding")
    private void stopRiding(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (((Object) this) instanceof PlayerEntity e && e.getWorld().isClient() && e == client.player) {
            client.options.setPerspective(AutoF5.CONFIG.returnPerspective().getPerspective(previousPerspective));
        }
    }
}