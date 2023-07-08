package Sprint_4_Task1;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("R2D2");
        Robot robot2 = new Robot("R2D2");

        Thread t1 = new Thread(robot1::attack);
        Thread t2 = new Thread(robot2::attack);

        t1.start();
        t2.start();
    }
}
