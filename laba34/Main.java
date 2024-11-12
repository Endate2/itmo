import Objects.Location;
import Objects.Neznaika;
import Constans.HumanConstans;
import Constans.PlaceConstans;
import Objects.Kozlik;
import Objects.Mirror;
import Objects.Entity;
import java.io.IOException;
import java.util.ArrayList;

class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String message) {
        super(message);
    }
}

public class Main {
    public record Shorties(int count, HumanConstans condition) {
        public void printCount() {
            System.out.println("Количество коротышек: " + count);
        }

        public void Condition(Entity first, Entity second, HumanConstans condition) {
            switch (condition) {
                case ANGRY:
                    first.setHp(0);
                    second.setHp(0);
                    System.out.println("Коротышки побили в подворотне " + first.getName() + " " + second.getName() + " поэтому их здоровье: " + first.getHp() + " " + second.getHp());
                    break;
                case HAPPY:
                    first.setWeight(first.getWeight() + 10);
                    second.setWeight(second.getWeight() + 10);
                    System.out.println("Коротышки поделились едой с " + first.getName() + " " + second.getName() + " поэтому их вес: " + first.getWeight() + " " + second.getWeight());
                    break;
                case HUNGER:
                    first.setCondition(HumanConstans.SAD);
                    second.setCondition(HumanConstans.SAD);
                    System.out.println("Коротышки украли еду у " + first.getName() + " " + second.getName() + " поэтому их настроение: " + first.getCondition() + " " + second.getCondition());
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Neznaika neznaika = new Neznaika("Незнайка", 140, HumanConstans.NOTHUNGER, 15, PlaceConstans.street, "123-456-7890");
        Kozlik kozlik = new Kozlik("Козлик", 50, HumanConstans.NOTHUNGER, 15, PlaceConstans.gym, "123-456-7890");

        Location location = new Location();
        Mirror mirror = new Mirror(true);
        ArrayList<Entity> entities = new ArrayList<>();
        entities.add(kozlik);
        entities.add(neznaika);
        
        for (Entity entity : entities) {
            System.out.println(entity.getName() + " есть в массиве Entities");
            try {
                entity.saveToFile("people.txt"); // Попытка сохранить информацию в файл
                System.out.println("Информация сохранена: " + entity.getInfo());
            } catch (IOException e) { // Обработка исключения
                System.out.println("Ошибка при сохранении информации: " + e.getMessage());
            }
        }

        try {
            if (!entities.contains(kozlik)) {
                throw new EntityNotFoundException("Сущность не найдена: " + kozlik.getName());
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }

        location.incrementPeopleCount(neznaika.getLocation());
        location.incrementPeopleCount(kozlik.getLocation());
        mirror.getSmile(neznaika.getName(), kozlik.getName());

        try {
            kozlik.performAction(kozlik, neznaika);
            neznaika.performAction(neznaika, kozlik);
            kozlik.call(neznaika, kozlik);
        } catch (NullPointerException e) { // Обработка Unchecked исключения
            System.out.println("Ошибка: " + e.getMessage());
        }

        Shorties shorties = new Shorties(3, HumanConstans.ANGRY);
        shorties.printCount();
        shorties.Condition(neznaika, kozlik, HumanConstans.ANGRY);
    }
}
