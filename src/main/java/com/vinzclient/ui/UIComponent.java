package com.vinzclient.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;

public abstract class UIComponent {
    protected int x, y, width, height;
    protected String text;

    public UIComponent(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public abstract void render(MatrixStack matrices, int mouseX, int mouseY);
}
