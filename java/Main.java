import Objects.Location;
import Objects.Neznaika;

import javax.swing.Action;

import Constans.HumanConstans;
import Constans.MirrorConstans;
import Constans.PlaceConstans;
import Objects.Kozlik;
import Objects.Mirror;

public class Main {
    public static void main(String[] args) {
        Neznaika e1 = new Neznaika("Незнайка", 140, HumanConstans.hunger, 10, PlaceConstans.street);
        Kozlik e2 = new Kozlik("Козлик", 50, HumanConstans.nothunger, 10, PlaceConstans.gym);

        Location street = new Location("Улица", 7, PlaceConstans.street);

        Location gym = new Location("Улица", 7, PlaceConstans.gym);

        Mirror Mirror = new Mirror(MirrorConstans.on);

        System.out.println();
        street.updatePeople(e1.getLocation());
        gym.updatePeople(e1.getLocation());
        street.updatePeople(e2.getLocation());
        gym.updatePeople(e2.getLocation());
        e2.start(e1); 
        e2.Drive(e1);
        e1.Phone("123-456-7890");
        Mirror.getSmile(e1.getName(),e2.getName());
    }
}
