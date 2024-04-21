package faang.school.godbless.army_of_heroes;

public class PowerThread extends Thread {

    private final Hero hero;
    private int power;

    PowerThread(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void run() {
        power = hero.getPower();

    }

    public int getPower() {
        return power;
    }

}
