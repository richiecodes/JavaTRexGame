package com.richiecodes.util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    private List<BufferedImage> frames;
    private int currentFrame = 0;
    private int deltaTime;
    private long previousTime;

    public Animation(int deltaTime) {
        this.deltaTime = deltaTime;
        frames = new ArrayList<BufferedImage>();
    }

    public void update() {
        if(System.currentTimeMillis() - previousTime > deltaTime) {
            currentFrame++;
            if (currentFrame >= frames.size()) {
                currentFrame = 0;
            }
            previousTime = System.currentTimeMillis();
        }
    }

    public void addFrame(BufferedImage frame) {
        frames.add(frame);
    }

    public BufferedImage getFrame() {
        if(frames.size() > 0) {
            return frames.get(currentFrame);
        }

        return null;
    }
}
