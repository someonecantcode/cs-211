package combine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferStrategy;
import java.util.*;
import javax.swing.JFrame;

class ShapeData {

    int x;
    int y;
    int size;
    int zoom;
    int speedX;
    int speedY;
    int angle;
    int angleSpeed;
    int angleDirection;
    Color color;
}

public class AllShapes extends JFrame implements Runnable {

    private Thread shapeThread;
    private boolean running = false;

    public static ArrayList<ShapeData> myShape = new ArrayList<>();
    static int width = 800;
    static int height = 600;
    static int howMany = 30;
    static int starSize = 10;
    public static int boardTop;
    static Random rand = new Random();
    static int R, G, B;

    public AllShapes(int screenWidth, int screenHeight, int howManyStars, int starSize) {
        super("CS211- Fall 2025");
        setBounds(100, 100, width, height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // add stars to the array and data
        // double buffering
        this.howMany = howManyStars;
        this.starSize = starSize;
        createBufferStrategy(2);
        createShape();
    }

    public static void createShape() {

        for (int i = 0; i < howMany; i++) {
            ShapeData s = new ShapeData();
            R = rand.nextInt(256);
            G = rand.nextInt(256);
            B = rand.nextInt(256);
            s.color = new Color(R, G, B);

            s.x = rand.nextInt(width);
            s.y = rand.nextInt(height);
            s.size = rand.nextInt(starSize) + 10;
            s.zoom = 1;
            s.speedX = rand.nextInt(5) + 1;
            s.speedY = rand.nextInt(5) + 1;

            s.angle = rand.nextInt(30);
            s.angleSpeed = rand.nextInt(2) + 1;
            if (rand.nextInt(2) == 0) {
                s.angleSpeed *= -1;
            }

            myShape.add(s);
        }
    }

    public synchronized void start() {
        running = true;
        shapeThread = new Thread(this);
        shapeThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            shapeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            paint();
            try {
                Thread.sleep(32); // org 16
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            return;
        }

        Graphics g = bs.getDrawGraphics();
        boardTop = height - getContentPane().getSize().height;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        for (int i = 0; i < myShape.size(); i++) {
            g.setColor(myShape.get(i).color);

            if (myShape.get(i).size > AllShapes.starSize) { // if zoom doesnt get out of threshold, it'll bug out
                myShape.get(i).zoom = -Math.abs(myShape.get(i).zoom);
            }

            if (myShape.get(i).size < 1) {
                myShape.get(i).zoom = Math.abs(myShape.get(i).zoom);
            }
            myShape.get(i).size += myShape.get(i).zoom;

            myShape.get(i).x += myShape.get(i).speedX;

            if (myShape.get(i).x > width - myShape.get(i).size) {

                myShape.get(i).x = width - myShape.get(i).size;

                myShape.get(i).speedX = -myShape.get(i).speedX;
            }

            if (myShape.get(i).x < myShape.get(i).size) {
                myShape.get(i).x = myShape.get(i).size;
                myShape.get(i).speedX = -myShape.get(i).speedX;
            }

            myShape.get(i).y += myShape.get(i).speedY;
            if (myShape.get(i).y > height - myShape.get(i).size) {
                myShape.get(i).y = height - myShape.get(i).size;
                myShape.get(i).speedY = -myShape.get(i).speedY;
            }

            if (myShape.get(i).y < boardTop + myShape.get(i).size) {
                myShape.get(i).y = boardTop + myShape.get(i).size;
                myShape.get(i).speedY = -myShape.get(i).speedY;
            }

            myShape.get(i).angle += myShape.get(i).angleSpeed;
            if (myShape.get(i).angle >= 360 || myShape.get(i).angle <= -360) {
                myShape.get(i).angle = 0;
            }

            drawAShape(g, myShape.get(i).x, myShape.get(i).y, myShape.get(i).size, myShape.get(i).angle, i);
        }
        g.dispose();
        bs.show();
    }

    private void drawAShape(Graphics g, int sx, int sy, int size, int angle, int index){
        System.out.println(size);
        switch(index % 3) {
            case 0 -> drawStar(g, sx, sy, size, angle);
            case 1 -> drawTriangle(g, sx, sy, size, angle);
            case 2 -> drawCircle(g, sx, sy, size);
        }
    }

    public void drawStar(Graphics g, int sx, int sy, int size, int angle) {
        int[] xCoords = new int[10];
        int[] yCoords = new int[10];
        int ang = 90 - angle;
        double rad;
        double PI = Math.PI;

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                rad = size * 0.38;
            } else {
                rad = size;
            }
            xCoords[i] += (int) (rad * Math.cos(PI * ang / 180.0));
            yCoords[i] -= (int) (rad * Math.sin(PI * ang / 180.0));
            ang += 36;
            xCoords[i] += sx;
            yCoords[i] += sy;
        }
        // g.fillPolygon(xCoords, yCoords, 10);

        Polygon p = new Polygon(xCoords, yCoords, 10);
        g.drawPolygon(p);
    }

     public void drawTriangle(Graphics g, int tx, int ty, int size, int angle) {
        int[] xCoords = new int[3];
        int[] yCoords = new int[3];


        for (int i = 0; i < 3; i++) {
            double ang = 2 * Math.PI * i /3 ;
            ang += Math.PI * angle/ 90;
            xCoords[i] += (int) (size * Math.cos(ang));
            yCoords[i] += (int) (size * Math.sin(ang));
            xCoords[i] += tx;
            yCoords[i] += ty;
        }

        // g.fillPolygon(xCoords, yCoords, 3);

        Polygon p = new Polygon(xCoords, yCoords, 3);
        g.drawPolygon(p);
    }

    public void drawCircle(Graphics g, int cx, int cy, int radius) {
        // Calculate the top-left corner of the bounding box for the circle
        int x = cx - radius;
        int y = cy - radius;
        int diameter = radius * 2;
        // outlined circle
        g.drawOval(x, y, diameter, diameter);
        // filled circle
        // g.fillOval(x, y, diameter, diameter);
    }

}
