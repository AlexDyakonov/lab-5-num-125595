package server.services;

import server.dao.HumanBeingDAO;
import server.dao.HumanBeingDAOImpl;
import server.model.HumanBeing;
import server.model.HumanBeingRequestDTO;
import server.model.HumanBeingResponseDTO;
import server.model.Mood;

import java.util.List;
import java.util.Set;

/**
 * The type Human being service.
 */
public class HumanBeingServiceImpl implements HumanBeingService {
    private final HumanBeingDAO humanBeingDAO;

    /**
     * Instantiates a new Human being service.
     */
    public HumanBeingServiceImpl() {
        this.humanBeingDAO = new HumanBeingDAOImpl();
    }

    @Override
    public String info() {
        return humanBeingDAO.info();
    }

    @Override
    public Set<HumanBeing> show() {
        return humanBeingDAO.show();
    }

    @Override
    public HumanBeingResponseDTO addElementToCollection(HumanBeingRequestDTO humanBeingRequestDTO) {
        return humanBeingDAO.addElementToCollection(humanBeingRequestDTO);
    }

    @Override
    public boolean findById(String id) {
        return humanBeingDAO.findById(id);
    }

    @Override
    public HumanBeingResponseDTO updateById(String id, HumanBeingRequestDTO humanBeingRequestDTO) {
        return humanBeingDAO.updateById(id, humanBeingRequestDTO);
    }

    @Override
    public void removeById(String id) {
        humanBeingDAO.removeById(id);
    }

    @Override
    public Set<HumanBeing> clear() {
        humanBeingDAO.clear();
        return null;
    }

    @Override
    public void save() {
        humanBeingDAO.save();
    }

    @Override
    public void executeScript(String fileName) {
        humanBeingDAO.executeScript(fileName);
    }

    @Override
    public void addIfMax(HumanBeingRequestDTO humanBeingRequestDTO) {
        humanBeingDAO.addIfMax(humanBeingRequestDTO);
    }

    @Override
    public void addIfMin(HumanBeingRequestDTO humanBeingRequestDTO) {
        humanBeingDAO.addIfMin(humanBeingRequestDTO);
    }

    @Override
    public HumanBeingResponseDTO maxByImpactSpeed() {
        return humanBeingDAO.maxByImpactSpeed();
    }

    @Override
    public void countByMood(Mood mood) {
        humanBeingDAO.countByMood(mood);
    }

    @Override
    public List<HumanBeing> printAscending() {
        return humanBeingDAO.printAscending();
    }

    @Override
    public int getSize() {
        return humanBeingDAO.getSize();
    }
}