package client.utility;

import server.model.Car;
import server.model.Coordinates;
import server.model.Mood;
import server.model.WeaponType;

public abstract class AbstractAsker {

    public abstract Car readCar();

    public abstract String readString();

    public abstract Float readFloat();

    public abstract Boolean readBool();

    public abstract String name();

    public abstract Float impactSpeed();

    public abstract Coordinates coordinates();

    public abstract Mood mood();

    public abstract WeaponType weaponType();

    public abstract Car car();

    public abstract HumanBeingRequestDTOBuilder humanBeingRequestDTOBuilder();
}
