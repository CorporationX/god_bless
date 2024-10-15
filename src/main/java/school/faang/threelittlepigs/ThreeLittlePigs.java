package school.faang.threelittlepigs;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread[] pigThreads = new PigThread[3];
        pigThreads[0] = new Pig1Thread();
        pigThreads[1] = new Pig2Thread();
        pigThreads[2] = new Pig3Thread();

        for (PigThread pigThread : pigThreads) {
            pigThread.start();
        }

        for (PigThread pigThread : pigThreads) {
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все дома построены - игра завершена!");
    }
}