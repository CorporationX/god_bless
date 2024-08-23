package faang.school.godbless.BJS2_24491;


public class Player {
    private static Object lock = new Object();
    private static boolean isPlaying = false;

    public static boolean isPlaying(){
        return isPlaying;
    }

    public void play() {
        synchronized (lock){
            isPlaying = true;
            System.out.println("Заиграл лучший трек");
        }
    }

    public void pause() {
        synchronized (lock){
            isPlaying = false;
            System.out.println("Лучший трек поставлен на паузу");
        }
    }

    public void skip() {
        synchronized (lock){
            isPlaying = true;
            System.out.println("Включился следующий трек");
        }
    }

    public void previous() {
        isPlaying = true;
        System.out.println("Включился предыдуший лучший трек");
    }
}
