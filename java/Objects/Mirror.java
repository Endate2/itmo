package Objects;

import Constans.MirrorConstans;

public class Mirror {
    protected MirrorConstans work;


    public Mirror(MirrorConstans work) { 
        this.work = work;
    }

    public MirrorConstans getWorkCondition(){
        return work;
    }

    public void getSmile(String name1, String name2) {
        if (work == MirrorConstans.on) {
            System.out.println("Зеркало смогло искзить лица "+ name1 + " и " +name2+" и они начали улыбаться");
        }else{
            System.out.println("Зеркало не смогло искзить лица "+ name1 + " и " +name2+" и они ушли грустные");
        }
    }
}
