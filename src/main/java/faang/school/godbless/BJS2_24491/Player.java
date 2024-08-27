package faang.school.godbless.BJS2_24491;


public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;


    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Музыка продолжает играть");
            } else {
                isPlaying = true;
                System.out.println("Заиграл лучший трек");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Лучший трек поставлен на паузу");
            } else {
                System.out.println("Лучший трек уже на паузе");
            }

        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Включился следующий трек");
            } else {
                isPlaying = true;
                System.out.println("Включился следующий трек");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Включился предыдуший лучший трек");
            } else {
                isPlaying = true;
                System.out.println("Включился предыдуший лучший трек");
            }
        }
    }
}
