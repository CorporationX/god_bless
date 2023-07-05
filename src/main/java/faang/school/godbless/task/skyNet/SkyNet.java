package faang.school.godbless.task.skyNet;

public class SkyNet {
    public static void main(String[] args) {
        Target rick = new Target("Rick Astley");
        Robot walle = new Robot("Wall-e", rick);
        Robot t1000 = new Robot("T-1000", rick);

        Thread walleThread = new Thread(walle::attack);
        Thread t1000Thread = new Thread(t1000::attack);

        walleThread.start();
        t1000Thread.start();
    }
}
