package ru.nsu.tsupa.logoworld;

import java.util.ArrayList;

public class Model {
    private ArrayList<Integer> field = new ArrayList<Integer>();

    private boolean isInit = false;
    private int width = 0;
    private int height = 0;

    private int posx = 0;
    private int posy = 0;
    private boolean isDrawing = false;

    public Model() {

    }

    public void initField(int x, int y) {
        field.clear();
        for (int i = 0; i < x*y; i++) {
            field.add(0);
        }

        width = x;
        height = y;
        posx = 0;
        posy = 0;
        isInit = true;
    }

    public void setPos(int x, int y) {
        if (isDrawing) {
            field.set(y*height + x, 1);
        }

        posx = x;
        posy = y;
    }

    public void setDrawing(boolean state) {
        isDrawing = state;
    }

    public void move(char c) {
        switch (c) {
            case 'L': {
                moveLeft();
                break;
            }
            case 'R': {
                moveRight();
                break;
            }
            case 'U': {
                moveUp();
                break;
            }
            case 'D': {
                moveDown();
                break;
            }
        }
    }

    private void moveLeft() {
        posx = (posx + width - 1) % width;
    }
    private void moveRight() {
        posx = (posx + 1) % width;
    }
    private void moveUp() {
        posy = (posy + height - 1) % height;
    }
    private void moveDown() {
        posy = (posy + 1) % height;
    }

    public void drawHere() {
        if (isDrawing) {
            field.set(posy*height + posx, 1);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public int getValue(int x, int y) {
        return field.get(y*height + x);
    }

    public boolean isDrawing() {
        return isDrawing;
    }

    public boolean isIn(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }
}
