package Multithreading.bc2612;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Robocop", "Tank");
        Robot robot2 = new Robot("Bumblebee", "Car");

        Thread thread1 = new Thread(robot1);
        Thread thread2 = new Thread(robot2);

        thread1.start();
        thread2.start();
    }
}
