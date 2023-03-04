package server.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandExecutor {
    public void startExecuting(InputStream input) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        try {
            CommandManager commandManager = new CommandManager();
            String line = "";
            while((line = reader.readLine()) != null){
                if (line.isEmpty()) continue;
                try {
                    commandManager.executeCommand(line.split(" "));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
