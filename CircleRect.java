public static float PI = 3.14159265358979323846F; // = (float) Math.PI

public static void drawRectCircle(float x, float y, float width, float height, float value, int color) {
    float radius = Math.max(width / 2F, height / 2F);

    GlStateManager.color(1F, 1F, 1F, 1F);
    GlStateManager.enableBlend();
    GlStateManager.disableTexture2D();
    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
    GlStateManager.color((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, (color >> 24 & 0xFF) / 255.0F);
    GL11.glBegin(GL11.GL_POLYGON);
    for (int i = 0; i <= 360; i++) {
        float xRadius = MathHelper.sin(i * PI / 180F) * (radius * value);
        float yRadius = MathHelper.cos(i * PI / 180F) * (radius * value);
        if (0 >= xRadius) {
            xRadius = Math.max(xRadius, -(width / 2F));
        } else {
            xRadius = Math.min(xRadius, width / 2F);
        }

        if (0 >= yRadius) {
            yRadius = Math.max(yRadius, -(height / 2F));
        } else {
            yRadius = Math.min(yRadius, height / 2F);
        }

        GL11.glVertex2d(x + width / 2F + xRadius, y + height / 2F + yRadius);
    }
    GL11.glEnd();
    GlStateManager.enableTexture2D();
    GlStateManager.disableBlend();
    GlStateManager.color(1F, 1F, 1F, 1F);
}
