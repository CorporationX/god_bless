package faang.school.godbless.synchronization.task_1.model;

public class Player {
    private Boolean isPlaying = false;

    public void play() {
        synchronized (isPlaying) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("музыка играет");
                isPlaying.notify();
            }
        }
    }

    public void pause() throws InterruptedException {
        synchronized (isPlaying) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("музыка на паузе");
                isPlaying.wait(3000);
            }

        }
    }

    public void skip() {
        System.out.println("следующая композиция");
    }

    public void previous() {
        System.out.println("предыдущая композиция");
    }
}