package Objects;

import java.util.HashMap;
import java.util.Map;
import Constans.PlaceConstans;

public class Location {
    private Map<PlaceConstans, Integer> locations;

    public Location() {
        locations = new HashMap<>();
        initializeLocations();
    }

    private void initializeLocations() {
        locations.put(PlaceConstans.cafe, 0);
        locations.put(PlaceConstans.street, 0);
        locations.put(PlaceConstans.club, 0);
        locations.put(PlaceConstans.gym, 0);
        locations.put(PlaceConstans.hospital, 0);
        locations.put(PlaceConstans.mortuary, 0);
    }

    public void incrementPeopleCount(PlaceConstans location) {
        if (locations.containsKey(location)) {
            locations.put(location, locations.get(location) + 1); 
            displayPeopleCount(location); 
        }
    }

    public void displayPeopleCount(PlaceConstans location) {
        if (locations.containsKey(location)) {
            System.out.println("В локации " + location + " теперь " + locations.get(location) + " человек.");
        }
    }
}
