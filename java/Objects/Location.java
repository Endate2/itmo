package Objects;

import Constans.PlaceConstans;

public class Location {
    protected String name;
    protected int people;
    protected PlaceConstans place;

    public Location(String name, int people, PlaceConstans place) { 
        this.name = name;
        this.people = people; 
        this.place = place;
    }

    public int getPeople(){
        return people;
    }

    public String getName() {
        return name; 
    }

    public void updatePeople(PlaceConstans first) {
        if (first == place) {
            people++;
            System.out.println("Количество людей в " + name + " увеличено на 1");
            GetPeople(place);
        }
    }
    public void GetPeople(PlaceConstans first) {
        System.out.println("Количество людей на " + place + ": " + people);
    }
}
