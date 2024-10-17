package school.faang.task321.music;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private boolean isPlaying;
    private Object lock;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Музыка играет");
        }
    }

    public void stop() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Музыка остановлена");
        }
    }

    public void skip(){
        synchronized (lock){
            System.out.println("Включен следующий трек");
        }
    }
    public void previous (){
        synchronized (lock){
            System.out.println("Включен предыдущий трек");
        }
    }
}
