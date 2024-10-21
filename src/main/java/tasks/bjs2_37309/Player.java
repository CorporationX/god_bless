package tasks.bjs2_37309;

import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;

@Getter
public class Player {
    private String userName;
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    public Player(String userName) {
        this.userName = userName;
    }

    public void executeAction(Consumer<Player> action) {
        Thread thread = Thread.currentThread();

        synchronized (lock) {
            System.out.println(thread.getName() + ". " + userName + ". Выполняет действие");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException("В процессе выполнения потока произошла ошибка : " + e.getMessage());
            }

            action.accept(this);
            System.out.println(thread.getName() + ". " + userName + ". Выполнил действие");
        }
    }

    public void play() {
        executeAction(player -> {
            if (player.isPlaying) {
                System.out.println("Музыка уже играет.");
                return;
            }
            player.isPlaying = true;
            System.out.println("Включили воспроизведение музыки");
        });
    }

    public void pause() {
        executeAction(player -> {
            if (!player.isPlaying) {
                System.out.println("Проигрывание музыки уже приостановленно");
                return;
            }
            player.isPlaying = false;
            System.out.println("Выключили воспроизведение музыки");
        });
    }

    public void skip() {
        executeAction(player -> {
            System.out.println("Пропустили трэк");
        });
    }

    public void previous() {
        executeAction(player -> {
            System.out.println("Вернули предыдущий трэк");
        });
    }
}
