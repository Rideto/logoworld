package ru.nsu.tsupa.logoworld.commands;

import ru.nsu.tsupa.logoworld.Model;
import ru.nsu.tsupa.logoworld.View;

import java.util.ArrayList;

public class Ward implements Command {
    public void execute(Model model, View view, ArrayList<String> parameters) {
        model.setDrawing(false);
        view.showMessage("Draw mode is OFF");
    }
}
