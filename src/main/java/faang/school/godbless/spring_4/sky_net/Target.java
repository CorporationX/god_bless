package faang.school.godbless.spring_4.sky_net;

public class Target {
    private int health = 100;

    public int getTarget() {
        return health;
    }

    public synchronized void takeAwayHealth(int attack) {
        health -= attack;
    }
}
