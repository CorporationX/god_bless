package faang.school.godbless.sprint_3.multithreading.sky_net;

public class SkyNet {
    public static void main(String[] args) {
        Robot firstRobot = new Robot("First terrorist");
        Robot secondRobot = new Robot("Second terrorist");
        Thread first = new Thread(firstRobot::attack);
        Thread second = new Thread(secondRobot::attack);
        first.start();
        second.start();
    }
}