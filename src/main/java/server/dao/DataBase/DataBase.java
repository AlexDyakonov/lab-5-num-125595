package server.dao.DataBase;

import server.model.HumanBeing;

import java.time.LocalDateTime;
import java.util.Set;

public interface DataBase {
    Set<HumanBeing> getDataBase();
    LocalDateTime getCreationDate();
    void saveDBToCSV();
}
