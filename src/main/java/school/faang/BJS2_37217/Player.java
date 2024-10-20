package school.faang.BJS2_37217;

import lombok.Data;

@Data
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public Player() {
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Воспроизведение");
            } else {
                System.out.println("Воспроиводится в данный момент");
            }
        }
    }
    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Прекращение проигрывания");
            }else {
                System.out.println("Не проигрывается");
            }
        }
    }
    public void skip(){
        synchronized (lock){
            System.out.println("Воспроизведение следующего трека");
        }
    }

    public void previous(){
        synchronized (lock){
            System.out.println("Воспроизведение предыдущего трека");
        }
    }
}
