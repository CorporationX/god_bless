package school.faang.BlockSpotify;

public class Player {
    static final Object lock = new Object();

    private boolean isPlaying = false;

    public void play() {
        synchronized (lock){
            if (!isPlaying()){
                setPlaying(true);
                System.out.println("Музыка воспроизводится");
            } else {
                System.out.println("Музыка уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock){
            if (isPlaying()){
                setPlaying(false);
                System.out.println("Музыка приостановлена");
            } else {
                System.out.println("Музыка уже стоит на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock){
            System.out.println("Трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock){
            System.out.println("Возвращение к предыдущему треку");
        }
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
