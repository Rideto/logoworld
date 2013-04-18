package ru.nsu.tsupa.logoworld.commands;

import ru.nsu.tsupa.logoworld.Model;
import ru.nsu.tsupa.logoworld.View;

import java.util.ArrayList;

public class Move implements Command {
    public void execute(Model model, View view, ArrayList<String> parameters) throws Exception {
        if ( parameters.size() < 2 ) {
            throw new Exception("Error: cannot move, don't know where to.");
        }

        int steps = 1;

        if (!parameters.get(1).toUpperCase().matches("^[LRUD]")) {
            throw new Exception("Error: cannot move, direction is unknown.");
        }

        if (parameters.size() > 2 ) {
            try {
                steps = Integer.parseInt(parameters.get(2));
            } catch (Exception e) {
                throw new Exception("Error: cannot move, steps amount is not a number.");
            }
        }

        int width = model.getWidth();
        int height = model.getHeight();

        String direction = parameters.get(1).toUpperCase();

        for ( int i = 0; i < steps; i++) {
            model.move(direction.charAt(0));
            if (model.isDrawing()) {
                model.drawHere();
            }
        }
    }
}
