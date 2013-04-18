package ru.nsu.tsupa.logoworld.factory;

import ru.nsu.tsupa.logoworld.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Factory {
    private TreeMap<String, Class> commandClasses = new TreeMap<String, Class>();

    public Factory() {
        TreeMap<String, String> commands = PropertyReader.getProperties();

        List<String> keyList = new ArrayList<String>(commands.keySet());

        for (String key : keyList ) {
            try {
                if (!commandClasses.containsKey(key)) {
                    commandClasses.put(key, Class.forName(commands.get(key)));
                }
            } catch (ClassNotFoundException e) {
                System.err.println("Error: command class not found.");
            }
        }
    }

    public Command getCommandExecutor(String name) {
        try {
            return (Command)commandClasses.get( name ).newInstance();
        } catch ( InstantiationException e ) {
            System.err.println("Error: cannot instantiate command executor.");
            e.printStackTrace();
        } catch ( IllegalAccessException e ) {
            System.err.println("Error: illegal access while instantiating command executor.");
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkCommandName(String command) {
        return commandClasses.containsKey(command);
    }
}
