package ru.nsu.tsupa.logoworld;

import ru.nsu.tsupa.logoworld.commands.Command;
import ru.nsu.tsupa.logoworld.factory.Factory;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class Controller {
    private final Model model;
    private final View view;
    private final Factory factory;
    private TreeMap<String, Command> executors = new TreeMap<String, Command>();
    private Command executor;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        factory = new Factory();
    }

    public void start() {
        view.showWelcome();

        Scanner scanner = new Scanner(System.in);
        String s = new String();
        Scanner parser;

        while (true) {
            try {
                s = scanner.nextLine();
                parser = new Scanner(s);
                ArrayList<String> parameters = new ArrayList<String>();

                while (parser.hasNext()) {
                    parameters.add(parser.next());
                }

                String command = parameters.get(0).toUpperCase();

                if (command.equals("QUIT")) {
                    view.showGoodBye();
                    break;
                }

                if (!factory.checkCommandName(command)) {
                    view.showErrMessage("Warning: cannot execute command \"" + command + "\".");
                    continue;
                }

                if (!executors.containsKey(command)) {
                    executors.put(command, factory.getCommandExecutor(command));
                }

                executor = executors.get(command);

                executor.execute(model, view, parameters);
                view.showField();
            }
            catch (Throwable e) {
                view.showErrMessage(e.getMessage());
            }
        }

    }
}
