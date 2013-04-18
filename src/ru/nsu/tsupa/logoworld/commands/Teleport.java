package ru.nsu.tsupa.logoworld.commands;

import ru.nsu.tsupa.logoworld.Model;
import ru.nsu.tsupa.logoworld.View;

import java.util.ArrayList;

public class Teleport implements Command {
    public void execute( Model model, View view, ArrayList<String> args ) throws Exception {
        if ( args.size() < 3 ) {
            throw new Exception("Error: can't teleport, don't know where to.");
        }

        int posx;
        int posy;

        try {
            posx = Integer.parseInt(args.get( 1 ));
            posy = Integer.parseInt(args.get( 2 ));
        } catch (Exception e) {
            throw new Exception("Error: cannot teleport, one of coordinates is not a number");
        }

        if (model.isIn(posx, posy)) {
            model.setPos(posx, posy);
        } else {
            throw new Exception("Error: can't teleport out of field.");
        }
    }
}
