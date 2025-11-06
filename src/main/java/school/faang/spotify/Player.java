package school.faang.spotify;

public class Player {
    private boolean isPlaying;
    public synchronized void play() {
        if (!isPlaying) {
            isPlaying = true;
            System.out.println("Музыка воспроизводится.");
        } else {
            System.out.println("Музыка уже играет.");
        }
    }

    public synchronized void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Музыка не играет.");
        }else {
            System.out.println("Музыка и так не играет");
        }
    }
    public synchronized void skip() {
        System.out.println("Трек пропущен.");
    }

    public synchronized void previous() {
        System.out.println("Вернулись к предыдущему треку.");
    }

}
