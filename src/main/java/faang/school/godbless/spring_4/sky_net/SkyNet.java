package faang.school.godbless.spring_4.sky_net;

public class SkyNet {
    public static void main(String[] args) throws InterruptedException {

        Target target = new Target();

        Robot[] robots = new Robot[]{new Robot(target), new Robot(target)};

        Thread[] threads = new Thread[robots.length];

        for (int i = 0; i < threads.length; i++) {
            int finalI1 = i;
            threads[i] = new Thread(() -> robots[finalI1].attack());
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println(target.getTarget());
    }
}
