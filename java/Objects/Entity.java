package Objects;

import interfaces.KozlikInterfaces;
import interfaces.NeznaikaInterfaces;

import java.util.Objects;

import javax.swing.Action;

import Constans.HumanConstans;
import Constans.PlaceConstans;

public class Entity extends Obj implements KozlikInterfaces,NeznaikaInterfaces {
    protected String name;
    protected int size;
    protected HumanConstans condition;
    protected int hp;
    protected PlaceConstans location;

    public Entity(String name, int size, HumanConstans condition, int hp, PlaceConstans location) {
        this.name = name;
        this.size = size;
        this.condition = condition;
        this.hp = hp;
        this.location = location;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public HumanConstans getCondition() {
        return condition;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void setLocation(PlaceConstans location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(getName().toLowerCase(), entity.getName().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().toLowerCase());
    }

    @Override
    public String toString() {
        return getName();
    }

    public void performAction(Entity first,Entity second) {
        HumanConstans currentCondition = first.getCondition();
        switch (currentCondition) {
            case hunger:
                System.out.println(first.getName() + " с завистью поглядывает на коротышек и мечтает о еде.");
                Fight(first, 5, second);  
                break;
            case nothunger:
                System.out.println(first.getName() + " сидит на лавочке и радостно наблюдает за коротышками.");
                Shares(first, 5,second);
                first.ClubDriving(second);
                break;
        }
    }
    

    public void start(Entity first) {
        performAction(first,this);
        performAction(this,first);
    }

    public void Fight(Obj first, int damage, Obj second) {
        int currentHp = first.getHp();
        currentHp -= damage;
        if (currentHp < 0) {
            currentHp = 0;
        }
        first.setHp(currentHp);
        System.out.println(first.getName() + " потерял " + damage + " HP из-за атаки " + second.getName());
        System.out.println("Теперь Hp "+ first.getName()+ " "+ first.getHp());
    }

    public void Shares(Obj first, int damage, Obj second) {
        int currentHp = first.getHp();
        currentHp += damage;
        first.setHp(currentHp);
        System.out.println(first.getName() + " получил " + damage + " HP из-за того что " + second.getName() + " поделился с ним едой");
        System.out.println("Теперь Hp "+ first.getName()+ " "+ first.getHp());
    }
    @Override
    public PlaceConstans getLocation() {
        return location; 
    }
    @Override
    public void printLocation(Entity object) {
        System.err.println(object.getName() + " находится в " + object.getLocation());
    }
    @Override
    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public void ClubDriving(Entity first){
        first.setLocation(PlaceConstans.club);
        this.setLocation(PlaceConstans.club);
        first.setSize(first.getSize()+50);
        this.setSize(this.getSize()+50);
        System.out.println(getName() + " поехал вместе с " + first.getName() + " в " + getLocation());
        System.out.println(getConditionAdjective(first)+" "+first.getName() + " и " +getConditionAdjective(first) + this.getName() + " наелись и напились и теперь они весят "+ first.getSize() + " " + this.getSize());
    }


    public String getConditionAdjective(Entity first) {
        switch (first.getCondition()) {
            case hunger:
                return "голодный ";
            case nothunger:
                return "неголодный ";
            case happy:
                return "радостный ";
            case drunk:
                return "пьяный ";
            default:
                return "неизвестное состояние";
        }
    }
}
