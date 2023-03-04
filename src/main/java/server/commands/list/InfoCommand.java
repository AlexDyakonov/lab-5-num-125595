package server.commands.list;

import server.commands.Command;

public class InfoCommand implements Command {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescr() {
        return null;
    }

    @Override
    public void execute() {

    }
}
