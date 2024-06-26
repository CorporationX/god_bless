package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_12_pig;

public class ThreeLittlePigs {
    private static final String MSG_END = "Все дома построены";
    public static void main(String[] args) {
        Thread[] threads = new Thread[]{
                new Pig1Thread("Ниф-ниф", 3),
                new Pig2Thread("Нaф-нaф", 6),
                new Pig3Thread("Нуф-нуф", 9)
        };

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(MSG_END);
    }
}
