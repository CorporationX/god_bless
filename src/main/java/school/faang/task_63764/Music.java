package school.faang.task_63764;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread[] threads = {new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous),
        };
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(thread.getName() + " поток был прерван! " + e);
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
