package server.commands.list;

import server.commands.Command;

public class AddCommand implements Command {
    @Override
    public String getName() {
        return "add";    }

    @Override
    public String getDescr() {
        return "Добавляет новый элемент в коллекцию.";
    }

    @Override
    public void execute() {


        System.out.println("Element added!");
    }
}
