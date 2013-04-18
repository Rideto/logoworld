package ru.nsu.tsupa.logoworld.commands;

import ru.nsu.tsupa.logoworld.Model;
import ru.nsu.tsupa.logoworld.View;

import java.util.ArrayList;

public class Draw implements Command {
    public void execute(Model model, View view, ArrayList<String> parameters) {
        model.setDrawing(true);
        view.showMessage("Draw mode is ON");
    }
}
