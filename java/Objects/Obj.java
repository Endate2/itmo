
package Objects;

import Constans.HumanConstans;
import Constans.PlaceConstans;

public abstract class Obj {
    public abstract String getName();
    
    public abstract int getSize();
    
    public abstract HumanConstans getCondition();
    
    public abstract int getHp();
    
    public abstract void setHp(int hp);
    
    public abstract void setLocation(PlaceConstans location);
    
}
