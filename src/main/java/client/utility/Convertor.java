package client.utility;

import server.exception.ApplicationException;
import server.exception.FileException;
import server.exception.ValidationException;
import server.model.Coordinates;
import server.model.Mood;
import server.model.WeaponType;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

import static client.ui.ConsoleColors.*;

public class Convertor {
    public static String fromFileToStr(String line){
        return line.replace("%COMMA%", ",");
    }

    /**
     * To float float.
     *
     * @param line the line
     * @return the float
     */
    public static Float toFloat(String line){
        try {
            return Float.parseFloat(line);
        } catch (NumberFormatException e) {
            throw new FileException(RED + line + RED_BRIGHT + " не соответствует требованию. Impactspeed принимает числовое значение. Запись будет проигнорирована."+ RESET);
        }
    }
    public static Integer getCoordinatesX(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
    public static Double getCoordinatesY(BufferedReader reader) throws IOException {
        return Double.parseDouble(reader.readLine());
    }
    /**
     * To coordinates coordinates.
     *
     * @param line the line
     * @return the coordinates
     */
    public static Coordinates fromFiletoCoordinates(String line){ // (1;1.0)
        String[] coordArr = line.replaceAll("[()]", "").split(";");
        if (coordArr.length != 2){
            throw new FileException(RED_BRIGHT + "Количество координат больше 2. Запись будет проигнорирована"+ RESET);
        }
        Coordinates coordinates = new Coordinates();
        try {
            Integer x = Integer.parseInt(coordArr[0].trim());
            Double y = Double.parseDouble(coordArr[1].trim());
            coordinates.setY(y);
            coordinates.setX(x);
            return coordinates;
        } catch (NumberFormatException e) {
            throw new FileException(RED_BRIGHT + "Координаты x,y неверного формата. Должны быть числа. Запись будет проигнорирована"+ RESET);
        }
    }

    /**
     * To local date time local date time.
     *
     * @param line the line
     * @return the local date time
     */
    public static LocalDateTime toLocalDateTime(String line){
        try {
            return LocalDateTime.parse(line);
        } catch (Exception e) {
            throw new FileException(RED_BRIGHT +"Неверно введено время создания файла. Запись будет проигнорирована"+ RESET);
        }
    }

    /**
     * To boolean boolean.
     *
     * @param line the line
     * @return the boolean
     */
    public static Boolean toBoolean(String line){
        switch (line.trim().toLowerCase()){
            case "true", "t" -> {
                return true;
            }
            case "false", "f" -> {
                return false;
            }
            default -> throw new ValidationException(RED + line + RED_BRIGHT + " не соответствует требованию. Значения не соответствуют необходимым true/false"+ RESET);
        }

    }

    /**
     * To wt weapon type.
     *
     * @param line the line
     * @return the weapon type
     */
    public static WeaponType toWeaponType(String line, String usage){
        switch (line.trim().toLowerCase()){
            case "axe", "1" -> {
                return WeaponType.AXE;
            }
            case "shotgun", "2" -> {
                return WeaponType.SHOTGUN;
            }
            case "bat", "3" -> {
                return WeaponType.BAT;
            }
            case "(null)", "null", "", "0" -> {
                return null;
            }
            default -> {
                switch (usage){
                    case "cmd" ->
                            throw new ValidationException(RED + line + RED_BRIGHT + " не соответствует требованию. Значения WeaponType могут быть AXE, SHOTGUN, BAT, null. Введите еще раз."+ RESET);
                    case "file" ->
                            throw new ValidationException(RED + line + RED_BRIGHT + " не соответствует требованию. Значения WeaponType могут быть AXE, SHOTGUN, BAT, null. Запись будет проигнорирована."+ RESET);
                    default ->
                            throw new ApplicationException("Введен неверный аргумент в команде toWeaponType");
                }
            }
        }
    }

    /**
     * To mood mood.
     *
     * @param line the line
     * @return the mood
     */
    public static Mood toMood(String line, String usage){
        switch (line.trim().toLowerCase()){
            case "sorrow", "1" -> {
                return Mood.SORROW;
            }
            case "gloom", "2" -> {
                return Mood.GLOOM;
            }
            case "apathy", "3" -> {
                return Mood.APATHY;
            }
            case "calm", "4" -> {
                return Mood.CALM;
            }
            case "rage", "5" -> {
                return Mood.RAGE;
            }
            default -> {
                switch (usage){
                    case "cmd" ->
                            throw new ValidationException(RED + line + RED_BRIGHT + " не соответствует требованию. Значения Mood могут быть SORROW, GLOOM, APATHY, CALM, RAGE. Введите еще раз."+ RESET);
                    case "file" ->
                            throw new ValidationException(RED + line + RED_BRIGHT + " не соответствует требованию. Значения Mood могут быть SORROW, GLOOM, APATHY, CALM, RAGE. Запись будет проигнорирована."+ RESET);
                    default ->
                            throw new ApplicationException("Введен неверный аргумент в команде Mood.");
                }
            }
        }
    }
}
