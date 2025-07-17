package src.codes;

import java.awt.Color;
import Utils.StopWatch;

public class MostBeautifulAnimation extends AnimationBase {
    protected int ledCount;
    protected int position = 0; // מיקום ההזזה
    protected StopWatch stopWatch = new StopWatch();

    protected Color baseColor;
    protected int interval;

    public MostBeautifulAnimation(Color color, int interval) {
        this.baseColor = color;
        this.interval = interval;
    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public void init() {
        ledCount = strip.getLedCount();
        stopWatch.start();
    }

    // פונקציה מחזירה צבע בקשת לפי מיקום (0-255)
    private Color wheel(int pos) {
        pos = 255 - pos;
        if (pos < 85) {
            return new Color(255 - pos * 3, 0, pos * 3);
        }
        if (pos < 170) {
            pos -= 85;
            return new Color(0, pos * 3, 255 - pos * 3);
        }
        pos -= 170;
        return new Color(pos * 3, 255 - pos * 3, 0);
    }

    @Override
    public void periodic() {
        for (int i = 0; i < ledCount; i++) {
            int colorIndex = (i * 256 / ledCount + position) & 255;
            strip.setLed(wheel(colorIndex), i);
        }
        strip.apply();

        position = (position + 1) % 256;
    }

    public double getRunTime() {
        return stopWatch.get() / 1000.0;
    }
}
