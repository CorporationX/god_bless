package school.faang.blockingsptifybjs49377;

public class Music {
    public static void main(String[] args) {
        Player musicPlayer = new Player();

        Runnable[] actions = {
                musicPlayer::play,
                musicPlayer::pause,
                musicPlayer::skip,
                musicPlayer::previous
        };

        Thread[] actionThreads = new Thread[actions.length];
        for (int i = 0; i < actions.length; i++) {
            actionThreads[i] = new Thread(actions[i]);
            actionThreads[i].start();
        }

        for (Thread actionThread : actionThreads) {
            try {
                actionThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All action completed");
    }
}
