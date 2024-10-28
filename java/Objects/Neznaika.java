package Objects;


import Constans.HumanConstans;
import Constans.PlaceConstans;

public class Neznaika extends Entity {
    
    public Neznaika(String name, int size, HumanConstans condition,int Hp, PlaceConstans Location) {
        super(name, size, condition,Hp,Location);
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[\\s-]", "");
        if (phoneNumber.length() == 10 || phoneNumber.length() == 11) {
            for (char c : phoneNumber.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true; 
        }
        return false; 
    }
    public void Phone(String PhoneNumber){
        if (isValidPhoneNumber(PhoneNumber)){
            System.out.println("--------СОЕДИНЕНИЕ УСТАНОВЛЕНО--------");
            this.setSize(getSize()+10);
            System.out.println(this.getName()+" смог дозвониться и заказал себе пиццу, теперь его вес "+getSize()); 
        }else{
            System.out.println("--------СОЕДИНЕНИЕ НЕ УСТАНОВЛЕНО--------");
            System.out.println(this.getName()+" неисмог дозвониться его вес остался "+getSize()); 
        }
    }


   
}
