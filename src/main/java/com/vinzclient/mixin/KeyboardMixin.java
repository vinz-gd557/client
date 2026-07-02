package com.vinzclient.mixin;

import com.vinzclient.ui.ClientMenuScreen;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.KeyboardCatcher.class) // This is a conceptual target, in actual 1.16.5 Fabric it's often Keyboard.java
public class KeyboardMixin {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    private void onKey(long window, int key, int scancode, int action, int mods, CallbackInfo ci) {
        if (key == GLFW.GLFW_KEY_RIGHT_SHIFT && action == GLFW.GLFW_PRESS) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.currentScreen == null) {
                client.setScreen(new ClientMenuScreen());
            }
            ci.cancel();
        }
    }
}
