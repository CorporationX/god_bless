package faang.school.godbless.skynet;

public class SkyNetc {

    public static void main(String[] args) {
        String target = "Target 1";
        Thread thread1 = new Thread(new Robot(target)::attack);
        Thread thread2 = new Thread(new Robot(target)::attack);

        thread1.start();
        thread2.start();
    }
}
