package faang.school.godbless;

public class PowerCalculatorThread extends Thread{
    private Hero hero;
    private int heroPower;

    public PowerCalculatorThread(Hero hero){
        this.hero = hero;
    }

    public int getHeroPower(){
        return heroPower;
    }

    @Override
    public void run(){
        heroPower = hero.getPower();
    }
}
