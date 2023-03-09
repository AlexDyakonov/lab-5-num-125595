package server.file;

import server.model.HumanBeing;

import java.util.Set;

public interface FileManager {
    void save(Set<HumanBeing> humanBeingSet, String fileName);
    Set<HumanBeing> load(String path);
}
