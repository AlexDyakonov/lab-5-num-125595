package server.services.file_logic;

import client.utility.AbstractAsker;
import client.utility.Convertor;
import client.utility.askerForHumanBeingRequestDTOBuilder;
import server.exception.ValidationException;
import server.model.Car;
import server.model.Coordinates;
import server.model.Mood;
import server.model.WeaponType;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The type File asker.
 */
public class FileAsker extends AbstractAsker {

    private final BufferedReader reader;

    /**
     * Instantiates a new File asker.
     *
     * @param reader the reader
     */
    public FileAsker(BufferedReader reader) {
        this.reader = reader;
    }

    public Car readCar() {
        Car car = new Car();
        String carName = readString();
        if (carName == null || carName.trim().equals("0") || carName.trim().equals("")) {
            return null;
        } else {
            car.setName(carName);
            car.setCool(readBool());
            return car;
        }
    }

    public String readString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось открыть поток чтения. Повторите.");
        }
    }

    public Float readFloat() {
        try {
            String ans = reader.readLine();
            return Float.parseFloat(ans);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось открыть поток чтения. Повторите.");
        } catch (NumberFormatException e) {
            throw new ValidationException("Значение impactspeed должно быть числовым. (z.B. 1.0)");
        }
    }

    public Boolean readBool() {
        try {
            return Convertor.toBoolean(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Не удалось открыть поток чтения. Повторите.");
        }
    }

    public String name() {
        return readString();
    }


    public Float impactSpeed() {
        return readFloat();
    }

    /**
     * Real hero boolean.
     *
     * @return the boolean
     */
    public Boolean realHero() {
        return readBool();
    }

    /**
     * Has tooth pick boolean.
     *
     * @return the boolean
     */
    public Boolean hasToothPick() {
        return readBool();
    }


    /**
     * Soundtrack name string.
     *
     * @return the string
     */
    public String soundtrackName() {
        return readString();
    }

    public Coordinates coordinates() {
        Coordinates coordinates = new Coordinates();
        try {
            coordinates.setX(Convertor.getCoordinatesX(reader));
            coordinates.setY(Convertor.getCoordinatesY(reader));
            return coordinates;
        } catch (IOException e) {
            System.out.println("Ошибка открытия потока чтения");
        } catch (NumberFormatException ex) {
            System.out.println("Координаты являются числами.");
        }
        return coordinates;
    }



    public Mood mood() {
        return Convertor.toMood(readString(), "file");
    }

    public WeaponType weaponType() {
        return Convertor.toWeaponType(readString(), "file");
    }

    public Car car() {
        return readCar();
    }

    public askerForHumanBeingRequestDTOBuilder humanBeingRequestDTOBuilder() {
        askerForHumanBeingRequestDTOBuilder humanBeingRequestDTOBuilder = new askerForHumanBeingRequestDTOBuilder();
        humanBeingRequestDTOBuilder
            .setName(name())
            .setCoordinates(coordinates())
            .setRealHero(realHero())
            .setHasToothpick(hasToothPick())
            .setImpactSpeed(impactSpeed())
            .setSoundtrackName(soundtrackName())
            .setWeaponType(weaponType())
            .setMood(mood())
            .setCar(car());
        return humanBeingRequestDTOBuilder;
    }


    /**
     * Gets reader.
     *
     * @return the reader
     */
    public BufferedReader getReader() {
        return reader;
    }
}
