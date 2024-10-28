package Objects;

import Constans.HumanConstans;
import Constans.PlaceConstans;

public class Kozlik extends Entity {

    public Kozlik(String name, int size, HumanConstans condition, int hp, PlaceConstans location) {
        super(name, size, condition, hp, location);
    }

    public void Drive(Entity first) {
        first.setLocation(PlaceConstans.cafe);
        System.out.println(getName() + " поехал в кафе вместе с " + first.getName());
        System.out.println(first.getName() + " сейчас находится в " + first.getLocation() + " так как "+ getName() + " подвез его");
        this.fitnes(first);
    }
    public void fitnes(Entity first) {
        first.setLocation(PlaceConstans.gym);
        System.out.println(getName() + " поехал в "+first.getLocation() + " вместе с " + first.getName());
        System.out.println(first.getName() + " сейчас тренируется с " + getName() + " в " + first.getLocation());
        first.setSize(first.getSize()-2);
        System.out.println(first.getName() + "похудел и теперь его вес составляет "+ first.getSize());
    }
}
