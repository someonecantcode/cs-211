package week3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import java.util.*;

class StarData {

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

public class Stars extends JFrame implements Runnable {

    private Thread starThread;
    private boolean running = false;

    public static ArrayList<StarData> myStar = new ArrayList<>();
    static int width = 800;
    static int height = 600;
    static int howMany = 30;
    static int starSize = 10;
    public static int boardTop;
    static Random rand = new Random();
    static int R, G, B;

    public Stars(int screenWidth, int screenHeight, int howManyStars, int starSize) {
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
        createStar();
    }

    public static void createStar() {

        for (int i = 0; i < howMany; i++) {
            StarData s = new StarData();
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

            myStar.add(s);
        }
    }

    public synchronized void start() {
        running = true;
        starThread = new Thread(this);
        starThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            starThread.join();
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

        for (int i = 0; i < myStar.size(); i++) {
            g.setColor(myStar.get(i).color);

            if (myStar.get(i).size > 40 || myStar.get(i).size < 1) {
                myStar.get(i).zoom *= -1;
            }
            myStar.get(i).size += myStar.get(i).zoom;

            myStar.get(i).x += myStar.get(i).speedX;

            if (myStar.get(i).x > width - myStar.get(i).size) {

                myStar.get(i).x = width - myStar.get(i).size;

                myStar.get(i).speedX = -myStar.get(i).speedX;
            }

            if (myStar.get(i).x < myStar.get(i).size) {
                myStar.get(i).x = myStar.get(i).size;
                myStar.get(i).speedX = -myStar.get(i).speedX;
            }

            myStar.get(i).y += myStar.get(i).speedY;
            if (myStar.get(i).y > height - myStar.get(i).size) {
                myStar.get(i).y = height - myStar.get(i).size;
                myStar.get(i).speedY = -myStar.get(i).speedY;
            }

            if (myStar.get(i).y < boardTop + myStar.get(i).size) {
                myStar.get(i).y = boardTop + myStar.get(i).size;
                myStar.get(i).speedY = -myStar.get(i).speedY;
            }

            myStar.get(i).angle += myStar.get(i).angleSpeed;
            if (myStar.get(i).angle >= 360 || myStar.get(i).angle <= -360) {
                myStar.get(i).angle = 0;
            }

            drawStar(g, myStar.get(i).x, myStar.get(i).y, myStar.get(i).size, myStar.get(i).angle, myStar.get(i).angleSpeed);

        }
        g.dispose();
        bs.show();
    }

    public void drawStar(Graphics g, int sx, int sy, int size, int angle, int angleSpeed) {
        int[] xCoords = new int[10];
        int[] yCoords = new int[10];
        int ang = 90 - angle;
        double rad;
        double PI = 3.14159;

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
        g.fillPolygon(xCoords, yCoords, 10);

        // appy recursion here
    }

    // public static void main(String[] args) {
    //     createStar();
    //     new Stars();
    // }
}
