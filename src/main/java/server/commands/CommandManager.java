package server.commands;

import server.commands.list.AddCommand;
import server.commands.list.HelpCommand;
import server.commands.list.InfoCommand;
import server.exception.CommandException;

import java.util.LinkedHashMap;
import java.util.Optional;

public class CommandManager {

    LinkedHashMap<String, Command> commands;

    /**
     * Constructor provides choice of commands behavior: ex. userMode or nonUserMode
     */
    public CommandManager() {
        commands = new LinkedHashMap<>();

        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("add", new AddCommand());
    }

    /**
     * Get all commands from manager.
     *
     * @return Map of loaded commands
     */
    public LinkedHashMap<String, Command> getCommands() {
        return commands;
    }

    /**
     * Universe method for command executing.
     *
     * @param args full separated line from stream
     */
    public void executeCommand(String[] args) {
        try {
            Optional.ofNullable(commands.get(args[0])).orElseThrow(() -> new CommandException("Указанная команда не была обнаружена")).execute();
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            throw new CommandException(e);
        }
    }
}
