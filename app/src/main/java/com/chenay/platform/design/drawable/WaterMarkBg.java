package com.chenay.platform.design.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WaterMarkBg extends Drawable {

    private final int[] colors;
    private Paint paintBg;
    private final Paint paintText;
    private String msg;
    private float degrees = 0;

    public WaterMarkBg(String msg, @NonNull float degrees, int[] colors, String textColor) {
        this.msg = msg;
        this.degrees = degrees;
        this.colors = colors;
        paintText = new Paint();
        if (textColor != null) {
            paintText.setColor(Color.parseColor(textColor));
        } else {
            paintText.setColor(Color.parseColor("#AEAEAE"));
        }
        paintText.setAntiAlias(true);
        paintText.setTextSize(30);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        int width = getBounds().right;
        int height = getBounds().bottom;
        if (colors != null) {
            float[] pos = {0f, 0.5f, 1.0f};
            paintBg = new Paint();
            LinearGradient gradient = new LinearGradient(0, 0, 0, height, colors, pos, Shader.TileMode.REPEAT);
            paintBg.setShader(gradient);
            canvas.drawRect(0, 0, width, height, paintBg);
        }
        if (!TextUtils.isEmpty(msg)) {
            canvas.save();
            canvas.rotate(degrees);
            float textWidth = paintText.measureText(msg);
            int index = 0;
            if (height >= width) {
                for (int positionY = height / 10; positionY <= height; positionY += height / 10) {
                    float fromX = -width + (index++ % 2) * textWidth;
                    for (float positionX = fromX; positionX < width; positionX += textWidth * 2) {
                        canvas.drawText(msg, positionX, positionY, paintText);
                    }
                }
            } else {
//                for (int posX = width / 6; posX <= width; posX += width / 6) {
//                    float fromY = -height + (index++ % 2) * textWidth;
//                    for (float posY = fromY; posY < height; posY += textWidth * 2) {
//                        canvas.drawText(msg,posX,posY,paintText);
//                    }
//                }

                for (int positionY = width / 6; positionY <= width; positionY += width / 6) {
                    float fromX = -width + (index++ % 2) * textWidth;
                    for (float positionX = fromX; positionX < width; positionX += textWidth * 2) {
                        canvas.drawText(msg, positionX, positionY, paintText);
                    }
                }
            }
            canvas.restore();
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
