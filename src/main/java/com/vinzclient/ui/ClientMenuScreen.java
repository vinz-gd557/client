package com.vinzclient.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.gui.DrawContext; // Note: DrawContext is for newer versions, for 1.16.5 we use MatrixStack and fill
import java.awt.Color;

public class ClientMenuScreen extends Screen {
    public ClientMenuScreen() {
        super(net.minecraft.client.gui.screen.Text.literal("Vinz Client Menu"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        // Background Overlay
        fill(matrices, 0, 0, this.width, this.height, new Color(0, 0, 0, 100).getRGB());

        // Main Menu Panel - Unique Design: Floating Center Card with Rounded-like appearance
        int panelWidth = 300;
        int panelHeight = 400;
        int panelX = (this.width - panelWidth) / 2;
        int panelY = (this.height - panelHeight) / 2;

        // Draw main panel (dark grey background)
        fill(matrices, panelX, panelY, panelX + panelWidth, panelY + panelHeight, 0xFF2C2C2C);
        
        // Header accent line (Blue)
        fill(matrices, panelX, panelY, panelX + panelWidth, panelY + 5, 0xFF3498DB);

        // Title
        this.drawCenteredText(matrices, this.text, panelX + panelWidth / 2, panelY + 20, 0xFFFFFFFF);

        // Custom "Buttons" (Simple Rectangles for this prototype)
        drawCustomButton(matrices, panelX + 50, panelY + 70, 200, 30, "Click GUI", mouseX, mouseY);
        drawCustomButton(matrices, panelX + 50, panelY + 110, 200, 30, "Combat", mouseX, mouseY);
        drawCustomButton(matrices, panelX + 50, panelY + 150, 200, 30, "Movement", mouseX, mouseY);
        drawCustomButton(matrices, panelX + 50, panelY + 190, 200, 30, "Visuals", mouseX, mouseY);
        drawCustomButton(matrices, panelX + 50, panelY + 230, 200, 30, "Settings", mouseX, mouseY);

        super.render(matrices, mouseX, mouseY, delta);
    }

    private void drawCustomButton(MatrixStack matrices, int x, int y, int width, int height, String text, int mouseX, int mouseY) {
        boolean hovered = (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height);
        int color = hovered ? 0xFF4A4A4A : 0xFF3A3A3A;
        
        fill(matrices, x, y, x + width, y + height, color);
        this.drawCenteredText(matrices, text, x + width / 2, y + (height / 2) - 4, 0xFFCCCCCC);
    }

    @Override
    public boolean isPauseScreen() {
        return false; // Don't pause the game when menu is open
    }
}
