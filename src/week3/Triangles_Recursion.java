package week3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Triangles_Recursion extends Triangles {
    private static Random rand = new Random();

    Triangles_Recursion(int screenWidth, int screenHeight, int howManyStars, int starSize) {
        super(screenWidth, screenHeight, howManyStars, starSize);
    }

    @Override
    public void drawTriangle(Graphics g, int tx, int ty, int size, int angle) {
        if (size < 3){
            return;
        } 

        int R = rand.nextInt(255);
        int G = rand.nextInt(255);
        int B = rand.nextInt(255);

        g.setColor(new Color(R, G, B));

        design2(g, tx, ty, size, angle);
    }

    private void design1(Graphics g, int tx, int ty, int size, int angle) {
        super.drawTriangle(g, tx, ty, size, angle);

        double offset = 1 * Math.PI/ 6; 
        for (int i = 0; i < 3; i++) {
            int xCoords = 0;
            int yCoords = 0;

            double ang = offset + 2 * Math.PI * i / 3;
            xCoords += (int) (size * Math.cos(ang));
            yCoords += (int) (size * Math.sin(ang));
            xCoords += tx;
            yCoords += ty;
            this.drawTriangle(g, xCoords, yCoords, size/2, angle);
        }
    }

    private void design2(Graphics g, int tx, int ty, int size, int angle) {
        super.drawTriangle(g, tx, ty, size, angle);
        for (int i = 0; i < 3; i++) {
            int xCoords = 0;
            int yCoords = 0;

            double ang = 2 * Math.PI * i / 3;
            ang += Math.PI * angle/ 90;
            xCoords += (int) (size * Math.cos(ang));
            yCoords += (int) (size * Math.sin(ang));
            xCoords += tx;
            yCoords += ty;
            this.drawTriangle(g, xCoords, yCoords, size/2, angle);
        }
    }
}
