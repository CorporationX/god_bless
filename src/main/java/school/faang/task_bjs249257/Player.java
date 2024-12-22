package school.faang.task_bjs249257;

public class Player {
    private boolean isPlaying = false;
    private final Object player = new Object();

    public void play() {
        synchronized (player) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Сняли с паузы");
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (player) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("поставили на паузу");
            } else {
                System.out.println("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (player) {
            if (isPlaying) {
                isPlaying = false;
            }
            isPlaying = true;
            System.out.println("Пропустили трек");
        }
    }

    public void previous() {
        synchronized (player) {
            if (isPlaying) {
                isPlaying = false;
            }
            isPlaying = true;
            System.out.println("вернули предыдущий трек");
        }
    }
}
