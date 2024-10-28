package interfaces;

import Constans.PlaceConstans;
import Objects.Entity;

public interface KozlikInterfaces {
    PlaceConstans getLocation();
    void printLocation(Entity object);
    void setSize(int size);
}
