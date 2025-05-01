package school.faang.BJS2_73273;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка пачынае граць...");
            } else {
                System.out.println("Музыка ўжо грае.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка пастаўлена на паўзу...");
            } else {
                System.out.println("Музыка ўжо на паўзе.");
            }
        }
    }

    public void skip() {
        synchronized (lock){
            System.out.println("Музыка пераскочыла на наступны трэк...");
        }
    }

    public void previous() {
        synchronized (lock){
            System.out.println("Музыка вярнулася на папярэдні трэк...");
        }
    }
}
