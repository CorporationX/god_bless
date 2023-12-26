package faang.school.godbless.BJS2_1216;

public class Player {
    private static String lock = "Это замок";
    private static Boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Включаем музыку");
                isPlaying = true;
            } else System.out.println("Музыка включена");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Ставим на паузу");
                isPlaying = false;
            } else System.out.println("Стоит на паузе");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Переключаем на следующий трек");
            } else System.out.println("Музыка не включена");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Переключаем на предыдущий трек");
            } else System.out.println("Музыка не включена");
        }
    }
}
