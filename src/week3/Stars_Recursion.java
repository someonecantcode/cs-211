package week3;

import java.awt.Graphics;
import java.awt.Color;

public class Stars_Recursion extends Stars {

    Stars_Recursion(int screenWidth, int screenHeight, int howManyStars, int starSize) {
        super(screenWidth, screenHeight, howManyStars, starSize);
    }

    @Override // i just need to add ,depth param and change the exit condition
    public void drawStar(Graphics g, int sx, int sy, int size, int angle) {
        if (size < 10){
            return;
        }

        int R = rand.nextInt(255);
        int G = rand.nextInt(255);
        int B = rand.nextInt(255);

        g.setColor(new Color(R, G, B));
        
        design1(g, sx, sy, size, angle);
    }

    private void design1(Graphics g, int sx, int sy, int size, int angle) {
        super.drawStar(g, sx, sy, size, angle);

        int ang = 90 - angle;
        double rad;
        double PI = Math.PI;

        for (int i = 0; i < 10; i++) {
            int xCoords = 0;
            int yCoords = 0;
            if (i % 2 == 0) {
                rad = size * 0.38;
            } else {
                rad = size;
            }
            xCoords += (int) (rad * Math.cos(PI * ang / 180.0));
            yCoords -= (int) (rad * Math.sin(PI * ang / 180.0));
            ang += 36;
            xCoords += sx;
            yCoords += sy;

            this.drawStar(g, xCoords, yCoords, size/2, angle);
        }


    }
}
