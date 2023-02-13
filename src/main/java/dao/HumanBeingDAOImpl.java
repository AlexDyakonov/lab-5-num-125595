package dao;

import DataBase.*;
import model.*;

// Тут будем взаимодействовать со сетом из класса ДатаБейз
public class HumanBeingDAOImpl implements HumanBeingDAO {
    private final DataBase dataBase = new DataBaseImpl();

    @Override
    public String info() {
        try {
            String dbType = dataBase.getDataBase().getClass().toString();
            String dbCreationTime = dataBase.getCreationDate().toString();
            int dbLength = dataBase.getDataBase().size();
            return ("List type: " + dbType + "\n List creation time: " + dbCreationTime + "\n List size: " + dbLength);
        } catch (NullPointerException e){
            return "List was not created yet.";
        }

    }

    @Override
    public void show() {

    }

    @Override
    public String addElementToCollection(HumanBeingRequestDTO humanBeingRequestDTO) {
        String name = humanBeingRequestDTO.getName();
        Coordinates coordinates = humanBeingRequestDTO.getCoordinates();
        Boolean realHero = humanBeingRequestDTO.getRealHero();
        Boolean hasToothpick = humanBeingRequestDTO.getHasToothpick();
        float impactSpeed = humanBeingRequestDTO.getImpactSpeed();
        String soundtrackName = humanBeingRequestDTO.getSoundtrackName();
        WeaponType weaponType = humanBeingRequestDTO.getWeaponType();
        Mood mood = humanBeingRequestDTO.getMood();
        Car car = humanBeingRequestDTO.getCar();
        HumanBeing humanBeing = new HumanBeing(name, coordinates, realHero, hasToothpick, impactSpeed, soundtrackName, weaponType, mood, car);
        dataBase.getDataBase().add(humanBeing);
        return (humanBeing.toString() + " has been added to List");
    }

    @Override
    public void updateById(Long id, HumanBeing humanBeing) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void save() {

    }

    @Override
    public void executeScript(String fileName) {

    }

    @Override
    public void addIfMax(HumanBeing humanBeing) {

    }

    @Override
    public void addIfMin(HumanBeing humanBeing) {

    }

    @Override
    public void maxByImpactSpeed(HumanBeing humanBeing) {

    }

    @Override
    public void countByMood(HumanBeing humanBeing) {

    }

    @Override
    public void printAscending() {

    }
}