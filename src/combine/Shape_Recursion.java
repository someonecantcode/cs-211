package combine;

import java.awt.Graphics;
import java.awt.Color;

public class Shape_Recursion extends AllShapes {

    Shape_Recursion(int screenWidth, int screenHeight, int howManyStars, int starSize) {
        super(screenWidth, screenHeight, howManyStars, starSize);
    }

    @Override // i just need to add ,depth param and change the exit condition
    public void drawStar(Graphics g, int sx, int sy, int size, int angle) {
        if (size < 15){
            return;
        }

        setRandomColor(g);
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

    @Override
    public void drawTriangle(Graphics g, int tx, int ty, int size, int angle) {
        if (size < 10){
            return;
        }

        setRandomColor(g);
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

    @Override // i just need to add ,depth param and change the exit condition
    public void drawCircle(Graphics g, int cx, int cy, int radius) {
        if (radius < 10){
            return;
        }

        setRandomColor(g);
        super.drawCircle(g, cx, cy, radius);
        this.drawCircle(g, cx, cy+radius, radius/2);
        this.drawCircle(g, cx, cy-radius, radius/2);
        this.drawCircle(g, cx+radius, cy, radius/2);
        this.drawCircle(g, cx-radius, cy, radius/2);
    }

    private void setRandomColor(Graphics g){
        int R = rand.nextInt(255);
        int G = rand.nextInt(255);
        int B = rand.nextInt(255);

        g.setColor(new Color(R, G, B));
    }

}
