package client.utility;

import server.exception.ValidationException;
import server.model.Car;
import server.model.Coordinates;
import server.model.Mood;
import server.model.WeaponType;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The type Console asker.
 */
public class ConsoleAsker extends AbstractAsker {
    private final BufferedReader reader;

    public ConsoleAsker(BufferedReader reader) {
        this.reader = reader;
    }



    public Car readCar() {
        Car car = new Car();
        System.out.println("Введите название машины. Если ее нет, то введите null/0/пустую строку");
        String carName = readString();
        if (carName == null || carName.trim().equals("0") || carName.trim().equals("")) {
            return null;
        } else {
            car.setName(carName);
            System.out.println("Введите крутая ли она? (true/false/t/f):");
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
        System.out.println("Введите имя пользователя:");
        return readString();
    }


    public Float impactSpeed() {
        System.out.println("Введите значение impact speed. Не может быть null и принимает числовое значение.");
        return readFloat();
    }

    /**
     * Real hero boolean.
     *
     * @return the boolean
     */
    public Boolean realHero() {
        System.out.println("Введите значение для real hero (true/false/t/f):");
        return readBool();
    }

    /**
     * Has tooth pick boolean.
     *
     * @return the boolean
     */
    public Boolean hasToothPick() {
        System.out.println("Введите значение для has toothpick (true/false/t/f):");
        return readBool();
    }


    /**
     * Soundtrack name string.
     *
     * @return the string
     */
    public String soundtrackName() {
        try {
            System.out.println("Введите название саундтрека:");
            return readString();
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return soundtrackName();
        }

    }

    public Coordinates coordinates() {
        Coordinates coordinates = new Coordinates();
        try {
            System.out.println("Введите координату х ");
            coordinates.setX(Convertor.getCoordinatesX(reader));
            System.out.println("Введите координату у ");
            coordinates.setY(Convertor.getCoordinatesY(reader));
            return coordinates;
        } catch (IOException e) {
            System.out.println("Ошибка открытия потока чтения");
        }
        return coordinates;
    }

    public Mood mood() {
        System.out.println("Введите настроение HumanBeing: (SORROW - 1, GLOOM - 2, APATHY - 3, CALM - 4, RAGE - 5)");
        return Convertor.toMood(readString(), "cmd");
    }

    public WeaponType weaponType() {
        System.out.println("Введите оружие HumanBeing: (AXE - 1, SHOTGUN - 2, BAT - 3, null - 0)");
        return Convertor.toWeaponType(readString(), "cmd");
    }

    public Car car() {
        return readCar();
    }

    public askerForHumanBeingRequestDTOBuilder humanBeingRequestDTOBuilder() {
        askerForHumanBeingRequestDTOBuilder humanBeingRequestDTOBuilder = new askerForHumanBeingRequestDTOBuilder();
        humanBeingRequestDTOBuilder.setName(name())
            .setCoordinates(coordinates()).setRealHero(
                realHero()).setHasToothpick(hasToothPick());
        humanBeingRequestDTOBuilder.setImpactSpeed(impactSpeed()).setSoundtrackName(
            soundtrackName()).setWeaponType(weaponType()).setMood(
            mood()).setCar(car());
        return humanBeingRequestDTOBuilder;
    }

}
