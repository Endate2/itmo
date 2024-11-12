package Objects;

import Constans.HumanConstans;
import Constans.PlaceConstans;
import interfaces.IHuman;


public class Kozlik extends Entity implements IHuman {
    public Kozlik(String name, int weight, HumanConstans condition, int hp, PlaceConstans location,String phone) {
        super(name, weight, condition, hp, location,phone);
    }
    @Override
    public void performAction(Entity first,Entity second) {
        HumanConstans currentCondition = first.getCondition();
        switch (currentCondition) {
            case HUNGER:
                System.out.println(first.getName() + " с завистью поглядывает на коротышек и мечтает о еде.");
                Fight(first, second);  
                break;
            case NOTHUNGER:
                System.out.println(first.getName() + " сидит на лавочке и радостно наблюдает за коротышками.");
                Shares(first,second);
                break;
            case HAPPY:
                System.out.println(first.getName() + " хорошее настроение поэтому он поехал в Club вместе с "+second.getName()+".");
                ClubDriving(first,second);
                break;
        }
    }
    @Override
    public void ClubDriving(Entity first,Entity second){
        if(Math.random() <0.5){
            second.setLocation(PlaceConstans.hospital);
            first.setLocation(PlaceConstans.hospital);
            first.setCondition(HumanConstans.WOUNDED);
            second.setCondition(HumanConstans.WOUNDED);
            second.setHp(first.getHp()-10);
            first.setHp(first.getHp()-10);
            System.out.println(this.getName()+" успел повернуть поэтому они вместе с "+ second.getName()+".");
            first.phone(first.getPhone());
            first.printHp(this,second);
        }else{
            first.setLocation(PlaceConstans.mortuary);
            this.setLocation(PlaceConstans.mortuary);
            first.setHp(0);
            this.setHp(0);
            this.setCondition(HumanConstans.WOUNDED);
            first.setCondition(HumanConstans.WOUNDED);
            this.phone(first.getPhone());
            System.out.println(this.getName()+" не успел повернуть поэтому их сбил грузовик они вместе с "+ first.getName()+ " попали в " + first.getLocation()+".");
        }
    }
    @Override
    public void Fight(Entity first, Entity second) {
        int currentHp = first.getHp();
        currentHp -= 10;
        if (currentHp < 0) {
            currentHp = 0;
        }
        first.setHp(currentHp);
        System.out.println(first.getName() + " потерял " + 10 + " HP из-за атаки " + second.getName()+".");
        System.out.println("Теперь Hp "+ first.getName()+ " "+ first.getHp()+".");
    }
    @Override
    public void Shares(Entity first, Entity second) {
        int currentHp = first.getHp();
        currentHp += 10;
        first.setHp(currentHp);
        System.out.println(first.getName() + " получил " + 10 + " HP из-за того что " + second.getName() + " поделился с ним едой.");
        System.out.println("Теперь Hp "+ first.getName()+ " "+ first.getHp()+".");
    }
}
