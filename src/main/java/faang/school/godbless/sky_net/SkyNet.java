package faang.school.godbless.sky_net;

public class SkyNet {
    public static void main(String[] args) {
        Target target = new Target("SkyNet target");

        Robot robotHarald = new Robot("Harald", target);
        Robot robotPetr = new Robot("Petr", target);

        Thread threadOne = new Thread(robotHarald::attack);
        Thread threadTwo = new Thread(robotPetr::attack);

        threadOne.start();
        threadTwo.start();
    }
}
