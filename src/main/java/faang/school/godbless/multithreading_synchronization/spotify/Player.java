package faang.school.godbless.multithreading_synchronization.spotify;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play(){
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Играет музыка");
        }
    }

    public void pause(){
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Музыка на паузе");
        }
    }

    public void skip(){
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Следующая музыка");
        }
    }

    public void previous(){
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Предыдущая музыка");
        }
    }
}
