package faang.school.godbless.spring_4.sky_net;

public class Target {
    private int target = 100;

    public int getTarget() {
        return target;
    }

    public synchronized void setTarget(int attack) {
        target -= attack;
    }
}
