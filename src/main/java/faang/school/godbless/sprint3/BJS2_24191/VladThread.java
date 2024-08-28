package faang.school.godbless.sprint3.BJS2_24191;

public class VladThread extends Thread {

    public VladThread(Runnable target) {
        super(target);
    }

    public VladThread(Runnable target, String threadName) {
        super(target, threadName);
    }

    public void vladStart() {
        super.start();
    }

    public void vladRun() {
        super.run();
    }

    public void joinVlad() throws InterruptedVladException {
        try {
            super.join();
        } catch (InterruptedException e) {
            throw new InterruptedVladException("Interrupted while waiting for thread to finish.", e);
        }
    }
}
