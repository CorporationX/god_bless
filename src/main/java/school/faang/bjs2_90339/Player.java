package school.faang.bjs2_90339;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Включаем песенку.");
            } else {
                System.out.println("Песенка уже поется.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Остановили песенку.");
            } else {
                System.out.println("Плеер и так молчит.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Переходим к следующей песенке.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Возвращаемся к предыдущей песенке.");
        }
    }
}
