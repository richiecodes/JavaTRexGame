package com.richiecodes.gameobjects;

import com.richiecodes.ui.GameScreen;
import com.richiecodes.util.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static com.richiecodes.ui.GameScreen.GROUND_Y;

public class Land {

    private List<ImageLand> listImage;
    private BufferedImage imageLand1, imageLand2, imageLand3;

    public Land(GameScreen game) {
        imageLand1 = Resource.getResourceImage("src/com/richiecodes/assets/land1.png");
        imageLand2 = Resource.getResourceImage("src/com/richiecodes/assets/land2.png");
        imageLand3 = Resource.getResourceImage("src/com/richiecodes/assets/land3.png");
        listImage = new ArrayList<ImageLand>();

        for(int i = 0; i < 600 / imageLand1.getWidth() + 2; i++) {
            ImageLand imageLand = new ImageLand();
            imageLand.posX = (int) (i * imageLand1.getWidth());
            imageLand.image = imageLand1;
            listImage.add(imageLand);
        }
    }

    public void update() {
        for(var image : listImage) {
            image.posX--;
        }
        ImageLand firstElement = listImage.get(0);

        if(firstElement.posX + imageLand1.getWidth() < 0) {
            firstElement.posX = listImage.get(listImage.size() - 1).posX + imageLand1.getWidth();
            listImage.add(firstElement);
            listImage.remove(0);
        }
    }

    public void draw(Graphics g) {
        for(var image : listImage) {
            g.drawImage(image.image, image.posX, (int) GROUND_Y - 15, null);
        }
    }

    private class ImageLand {
        int posX;
        BufferedImage image;
    }
}
