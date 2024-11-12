package Objects;


import Constans.HumanConstans;
import Constans.PlaceConstans;
import interfaces.IHuman;

public class Neznaika extends Entity implements IHuman{
    
    public Neznaika(String name, int weight, HumanConstans condition,int Hp, PlaceConstans Location,String phone) {
        super(name, weight, condition,Hp,Location,phone);
    }
    @Override
    public void performAction(Entity first,Entity second) {
        HumanConstans currentCondition = first.getCondition();
        switch (currentCondition) {
            case HUNGER:
                System.out.println(first.getName() + " с завистью поглядывает на коротышек и мечтает о еде.");
                Shares(first, second);
                break;
            case NOTHUNGER:
                System.out.println(first.getName() + " сидит на лавочке и радостно наблюдает за коротышками.");
                Fight(first, second); 
                break;
            case HAPPY:
                System.out.println(first.getName() + " хорошее настроение поэтому он поехал в Club вместе с "+second.getName()+".");
                ClubDriving(first,second);
                break;
        }
    }
    @Override
    public void ClubDriving(Entity first, Entity second){
        second.setLocation(PlaceConstans.club);
        first.setLocation(PlaceConstans.club);
        second.setSize(second.getWeight()+50);
        first.setSize(first.getWeight()+50);
        System.out.println(getName() + " поехал вместе с " + second.getName() + " в " + first.getLocation());
        System.out.println(getConditionAdjective(second)+" "+second.getName() + " и " +getConditionAdjective(first) + first.getName() + " наелись и напились и теперь они весят "+ second.getWeight() + " " + first.getWeight()+".");
        this.setCondition(HumanConstans.NOTHUNGER);
        this.phone(first.getPhone());
    } 
    @Override
    public void Fight(Entity first,Entity second) {
        first.setLocation(PlaceConstans.gym);
        second.setLocation(PlaceConstans.gym);
        System.out.println(getName() + " поехал в "+this.getLocation() + " вместе с " + second.getName()+" так как "+this.getName()+" вызвал его на поединок.");
        System.out.println(first.getName() + " сейчас дерутся с " + this.getName() + " на ринге.");
        this.setSize(this.getWeight()-2);
        this.setHp(2);
        second.setLocation(PlaceConstans.hospital);
        System.out.println(this.getName() + "похудел и теперь его вес составляет "+ this.getWeight()+" а " + second.getName()+" отправился в "+second.getLocation()+" так как его отправили в нокаут.");
    }
    @Override
    public void Shares(Entity first, Entity second) {
        int currentHp = first.getHp();
        currentHp += 10;
        first.setHp(currentHp);
        first.setLocation(PlaceConstans.cafe);
        System.out.println(getName() + " поехал в кафе вместе с " + first.getName());
        System.out.println(first.getName() + " сейчас находится в " + first.getLocation() + " так как "+ getName() + " подвез его.");

    }
}
