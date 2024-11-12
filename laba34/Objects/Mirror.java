package Objects;

public class Mirror {
    protected boolean isWorking;

    public Mirror(boolean work) {
        this.isWorking = work; // Изменено на work
    }

    public boolean getWorkCondition() {
        return isWorking;
    }

    public void getSmile(String name1,String name2) {
        if (isWorking) {  
            System.out.println("Зеркало смогло изобразить лица " + name1 + " и " + name2 + " и они начали улыбаться");
        } else {
            System.out.println("Зеркало не смогло изобразить лица " + name1 + " и " + name2 + " и они ушли грустные");
        }
    }
}
