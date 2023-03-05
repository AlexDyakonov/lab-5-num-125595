package server.dao;

import server.model.HumanBeing;
import server.model.HumanBeingRequestDTO;
import server.model.HumanBeingResponseDTO;
import server.model.Mood;

import java.util.List;
import java.util.Set;

public interface HumanBeingDAO {
    String info();

    Set<HumanBeing> show();

    HumanBeingResponseDTO addElementToCollection(HumanBeingRequestDTO humanBeingRequestDTO);

    boolean findById(String id);

    HumanBeingResponseDTO updateById(String id, HumanBeingRequestDTO humanBeingRequestDTO);

    void removeById(String id);

    Set<HumanBeing> clear();

    void save();

    void executeScript(String fileName);

    void addIfMax(HumanBeingRequestDTO humanBeingRequestDTO);

    void addIfMin(HumanBeingRequestDTO humanBeingRequestDTO);

    HumanBeingResponseDTO maxByImpactSpeed();

    void countByMood(Mood mood);

    List<HumanBeing> printAscending();

    int getSize();
}
