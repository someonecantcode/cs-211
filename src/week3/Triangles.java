package week3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferStrategy;
import java.util.*;
import javax.swing.JFrame;

class TriangleData {
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

public class Triangles extends JFrame implements Runnable {

    private Thread triangleThread;
    private boolean running = false;

    public static ArrayList<TriangleData> myTriangle = new ArrayList<>();
    static int width = 800;
    static int height = 600;
    static int howMany = 30;
    static int starSize = 10;
    public static int boardTop;
    static Random rand = new Random();
    static int R, G, B;

    public Triangles(int screenWidth, int screenHeight, int howManyTriangle, int triangleSize) {
        super("CS211 Triangles - Winter 2026");
        setBounds(100, 100, width, height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // add stars to the array and data
        // double buffering
        this.howMany = howManyTriangle;
        this.starSize = triangleSize;
        createBufferStrategy(2);
        createStar();
    }

    public static void createStar() {

        for (int i = 0; i < howMany; i++) {
            TriangleData s = new TriangleData();
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

            myTriangle.add(s);
        }
    }

    public synchronized void start() {
        running = true;
        triangleThread = new Thread(this);
        triangleThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            triangleThread.join();
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

        for (int i = 0; i < myTriangle.size(); i++) {
            g.setColor(myTriangle.get(i).color);

            if (myTriangle.get(i).size > Triangles.starSize) { // if zoom doesnt get out of threshold, it'll bug out
                myTriangle.get(i).zoom = -Math.abs(myTriangle.get(i).zoom);
            }

            if (myTriangle.get(i).size < 1) {
                myTriangle.get(i).zoom = Math.abs(myTriangle.get(i).zoom);
            }
            myTriangle.get(i).size += myTriangle.get(i).zoom;

            myTriangle.get(i).x += myTriangle.get(i).speedX;

            if (myTriangle.get(i).x > width - myTriangle.get(i).size) {

                myTriangle.get(i).x = width - myTriangle.get(i).size;

                myTriangle.get(i).speedX = -myTriangle.get(i).speedX;
            }

            if (myTriangle.get(i).x < myTriangle.get(i).size) {
                myTriangle.get(i).x = myTriangle.get(i).size;
                myTriangle.get(i).speedX = -myTriangle.get(i).speedX;
            }

            myTriangle.get(i).y += myTriangle.get(i).speedY;
            if (myTriangle.get(i).y > height - myTriangle.get(i).size) {
                myTriangle.get(i).y = height - myTriangle.get(i).size;
                myTriangle.get(i).speedY = -myTriangle.get(i).speedY;
            }

            if (myTriangle.get(i).y < boardTop + myTriangle.get(i).size) {
                myTriangle.get(i).y = boardTop + myTriangle.get(i).size;
                myTriangle.get(i).speedY = -myTriangle.get(i).speedY;
            }

            myTriangle.get(i).angle += myTriangle.get(i).angleSpeed;
            if (myTriangle.get(i).angle >= 360 || myTriangle.get(i).angle <= -360) {
                myTriangle.get(i).angle = 0;
            }

            drawTriangle(g, myTriangle.get(i).x, myTriangle.get(i).y, myTriangle.get(i).size, myTriangle.get(i).angle);
        }
        g.dispose();
        bs.show();
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

    public void drawUprightTriangle(Graphics g, int tx, int ty, int size, int angle) {
        int[] xCoords = new int[3];
        int[] yCoords = new int[3];

        double offset = 1 * Math.PI/ 6; 
        for (int i = 0; i < 3; i++) {
            double ang = offset + 2 * Math.PI * i / 3;
            xCoords[i] += (int) (size * Math.cos(ang));
            yCoords[i] += (int) (size * Math.sin(ang));
            xCoords[i] += tx;
            yCoords[i] += ty;
        }

        // g.fillPolygon(xCoords, yCoords, 3);

        Polygon p = new Polygon(xCoords, yCoords, 3);
        g.drawPolygon(p);
    }

}
