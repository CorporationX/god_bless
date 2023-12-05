package Sprint_4_SkyNet;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("oneTarget");
        Robot robot2 = new Robot("oneTarget");

        Thread robot1Thread = new Thread(() -> robot1.attack());
        Thread robot2Thread = new Thread(() -> robot2.attack());

        //Thread robot2Thread = new Thread(robot2::attack);
        //Thread robot2Thread = new Thread(r2 -> {robot2.attack()});

        robot1Thread.start();
        robot2Thread.start();
    }
}
