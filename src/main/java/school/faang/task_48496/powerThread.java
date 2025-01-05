package school.faang.task_48496;

public class powerThread extends Thread{
    private final Hero hero;
    private int power;

    public powerThread(Hero hero){
        this.hero = hero;
    }

    public int getPower() {
        return hero.getPower();
    }
}
