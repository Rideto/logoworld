package ru.nsu.tsupa.logoworld.commands;

import ru.nsu.tsupa.logoworld.Model;
import ru.nsu.tsupa.logoworld.View;

import java.util.ArrayList;

public class Init implements Command {
    public void execute(Model model, View view, ArrayList<String> parameters) throws Exception {
    if (parameters.size() < 3) {
        throw new Exception("Error: cannot initialize field: size not specified.");
    }

    int width;
    int height;

    try {
        width = Integer.parseInt(parameters.get(1));
        height = Integer.parseInt(parameters.get(2));
    } catch (Exception e) {
        throw new Exception("Error: cannot initialize field: 'width' or 'height' is not a number");
    }

    model.initField(width, height);

    if ( parameters.size() > 3 ) {
        int posx;
        int posy;
        try {
            posx = Integer.parseInt(parameters.get(3));
            posy = Integer.parseInt(parameters.get(4));
        } catch (Exception e) {
            throw new Exception( "Error: cannot initialize field: one of turtle coordinates is not a number." );
        }
        model.setPos(posx, posy);
    }
}
}
