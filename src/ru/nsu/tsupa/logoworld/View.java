package ru.nsu.tsupa.logoworld;

import java.util.TreeMap;

public class View {
    private final Model model;
    private TreeMap<String, Character> elements = new TreeMap<String, Character>();

    public View(Model model) {
        this.model = model;

        elements.put("Empty", ' ');
        elements.put("Shaded", 'X');      //'\u25A0'
        elements.put("Ward", 'O');
        elements.put("Draw", '\u00A9');
        elements.put("ULCorner", '+');        //'\u2554'
        elements.put("UHLine", '-');        //'\u2550'
        elements.put("URCorner", '+');       //'\u2557'
        elements.put("LVLine", '|');              //'\u2551'
        elements.put("RVLine", '|');
        elements.put("DLCorner", '+');        //'\u255A'
        elements.put("DHLine", '-');
        elements.put("DRCorner", '+');       //'\u255D'
    }

    public void showWelcome() {
        System.out.println("Welcome to LogoWorld!");
    }

    public void showGoodBye() {
        System.out.println("Thank you for using our services.");
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showErrMessage(String msg) {
        System.out.println("Oops! " + msg);
    }

    public void showField() {
        int width = model.getWidth();
        int height = model.getHeight();
        int posx = model.getPosx();
        int posy = model.getPosy();

        drawUpperHorizontalLine();

        for(int y = 0; y < height; y++) {
            System.out.print(elements.get("LVLine"));
            for (int x = 0; x < width; x++) {
                if (x == posx && y == posy) {
                    System.out.print(elements.get("Empty"));
                    if (model.isDrawing()) {
                        System.out.print(elements.get("Draw"));
                    } else {
                        System.out.print(elements.get("Ward"));
                    }
                    System.out.print(elements.get("Empty"));
                } else {
                    if (model.getValue(x, y) == 0) {
                        System.out.print(elements.get("Empty"));
                        System.out.print(elements.get("Empty"));
                        System.out.print(elements.get("Empty"));
                    } else {
                        System.out.print(elements.get("Empty"));
                        System.out.print(elements.get("Shaded"));
                        System.out.print(elements.get("Empty"));
                    }
                }
                if (x != width-1) System.out.print('|');
            }
            System.out.println(elements.get("RVLine"));
            drawUpperHorizontalLine();
        }
    }

    private void drawUpperHorizontalLine() {
        System.out.print(elements.get("ULCorner"));
        for (int i = 0; i < model.getWidth(); i++) {
            System.out.print(elements.get("UHLine"));
            System.out.print(elements.get("UHLine"));
            System.out.print(elements.get("UHLine"));
            System.out.print(elements.get("ULCorner"));
        }
        System.out.println();//(elements.get("URCorner"));
    }
    private void drawLowerHorizontalLine() {
        System.out.print(elements.get("DLCorner"));
        for (int i = 0; i < model.getWidth(); i++) {
            System.out.print(elements.get("DHLine"));
            System.out.print(elements.get("DHLine"));
            System.out.print(elements.get("DHLine"));
            System.out.print(elements.get("DLCorner"));
        }
        System.out.println();//(elements.get("DRCorner"));
    }
}