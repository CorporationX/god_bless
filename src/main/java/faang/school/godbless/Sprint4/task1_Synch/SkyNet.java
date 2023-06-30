package faang.school.godbless.Sprint4.task1_Synch;

public class SkyNet {
    public static void main(String[] args) {
        Robot t800 = new Robot("T800", "T1000");
        Robot t1000 = new Robot("T1000", "T800");

        Thread thread1 = new Thread(t800::attack);
        Thread thread2 = new Thread(t1000::attack);

        thread1.start();
        thread2.start();
    }
}
