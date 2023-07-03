package faang.school.godbless.skynet;

public class SkyNet {
    public static void main(String[] args) {
        Target targetOne = new Target("самолет");
        Target targetTwo = new Target("корабль");
        Robot robotOne = new Robot(targetTwo);
        Robot robotTwo = new Robot(targetOne);
        Thread threadOne = new Thread(() -> robotOne.attack());
        Thread threadTwo = new Thread(() -> robotTwo.attack());
        threadOne.start();
        threadTwo.start();
    }
}
