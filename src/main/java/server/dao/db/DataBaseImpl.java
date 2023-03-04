package server.dao.db;

import server.model.HumanBeing;
import server.services.file_logic.FileManager;
import server.services.file_logic.FileManagerImpl;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import static client.ui.ConsoleColors.GREEN_BRIGHT;
import static client.ui.ConsoleColors.RESET;

/**
 * The type Data base.
 */
public class DataBaseImpl implements DataBase {
    private Set<HumanBeing> dataBase;
    private final java.time.LocalDateTime creationDate = LocalDateTime.now();
    private final FileManager fileManager = new FileManagerImpl();

    /**
     * Instantiates a new Data base.
     */
    public DataBaseImpl() {
        try {
            dataBase = new LinkedHashSet<>(fileManager.load("database.csv"));
            System.out.println(GREEN_BRIGHT + "Успешно загружено " + dataBase.size() + " элементов." + RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            dataBase = new LinkedHashSet<>();
        }

    }

    public Set<HumanBeing> getDataBase() {
        return dataBase;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    private String toCSV(){
        StringBuilder outputString = new StringBuilder();
        for (HumanBeing humanBeing : dataBase){
            outputString.append(humanBeing.toCSV()).append("\n");
        }
        return outputString.toString();
    }
    @Override
    public void save() {
        fileManager.save(dataBase, "bebra");
    }
}