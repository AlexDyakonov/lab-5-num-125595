package client.ui;

import client.utility.ConsoleAsker;
import server.services.CommandExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * The type Console client.ui.
 */
public class ConsoleUI {

    private final CommandExecutor commandExecutor;

    public ConsoleUI() {
        this.commandExecutor = new CommandExecutor(new ConsoleAsker(new BufferedReader(new InputStreamReader(System.in))));
    }

    public void start() {
        System.out.println(MenuConstants.HELP);
        String line;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!Objects.equals(line = reader.readLine(), "exit")) {
                commandExecutor.execute(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
