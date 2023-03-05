package server.services;

import client.utility.ConsoleAsker;
import server.controller.HumanBeingController;
import server.controller.HumanBeingControllerImpl;
import server.exception.ApplicationException;
import server.exception.FileException;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScriptExecutor implements Executor {

    private List<String> previousFiles;
    private final CommandExecutor commandExecutor; // нужен для выполнения команд

    public ScriptExecutor() {
        this.previousFiles = new ArrayList<>();
        this.commandExecutor = new CommandExecutor(new ConsoleAsker(new BufferedReader(new InputStreamReader(System.in))));
    }

    // основной метод, запускает выполнение скрипта
    public void executeScript(String fileName) {
        executeListCommand(readCommandFromFile(fileName));
    }

    //todo
    // читает команды из файла
    public List<String> readCommandFromFile(String filename) {
        List<String> commandFromFile = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                if (previousFiles.contains(filename)) {
                    throw new ApplicationException("Скрипт вызывает сам себя");
                }
                previousFiles.add(filename);
                commandFromFile.add(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new FileException(filename + " не был найден.");
        } catch (IOException e){
            throw new FileException(filename + " не был найден2."); //TODO проверить ошибки
        }
        return commandFromFile;
    }

    // выполняет команды из файла
    private void executeListCommand(List<String> listOfCommand) {
        for (String command : listOfCommand) {
            commandExecutor.execute(command);
        }
    }
}