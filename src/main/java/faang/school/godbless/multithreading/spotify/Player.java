package faang.school.godbless.multithreading.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;


    public void play(){
        System.out.println(Thread.currentThread().getName() + " хочет воспроизвести композицию");
        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " проигрывает композицию");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pause(){
        synchronized (lock) {
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " поставил композицию на паузу");
        }
    }

    public void skip(){
        synchronized (lock) {
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " пропускает композицю");
        }
    }

    public void previos(){
        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " воспроизводит предыдущую композицию");
        }
    }

}
