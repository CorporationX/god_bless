package faang.school.godbless.spring_4.sky_net;

public class Robot {
    private final Target target;

    private int attack = 10;

    public Robot(Target target) {
        this.target = target;
    }

    public void attack() {
        target.takeAwayHealth(attack);
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
