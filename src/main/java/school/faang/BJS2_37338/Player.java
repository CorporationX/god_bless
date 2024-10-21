package school.faang.BJS2_37338;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    private  void performAction(String song) {
        synchronized (lock) {
            String user = Thread.currentThread().getName();
            if (!isPlaying) {
                isPlaying = true;
                System.out.printf("%s выполняет действие: %s\n", user,song);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.printf("Произошла ошибка: %s\n", e.getMessage());
                } catch (Exception e) {
                    System.out.printf("Произошла ошибка: %s\n", e.getMessage());
                }
                isPlaying = false;
                System.out.printf("%s завершил действие: %s\n", user,song);
            } else {
                System.out.printf("Действие %s невозможно, так как плеер уже занят.", song);
            }
        }
    }
    public void play() {
        performAction("Воспроизведение");
    }

    public void pause() {
        performAction("Пауза");
    }

    public void stop() {
        performAction("Остановка");
    }

    public void skip() {
        performAction("Пропуск");
    }
}
