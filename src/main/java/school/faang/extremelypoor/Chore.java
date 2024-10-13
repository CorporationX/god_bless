package school.faang.extremelypoor;

import lombok.Getter;
import lombok.SneakyThrows;

public class Chore implements Runnable {
    @Getter
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("Поток %s сейчас выполняет \"%s.\"\n",
                Thread.currentThread().getName(), chore);
        Thread.sleep(5000);
        System.out.printf("Завершена задача \"%s\" потоком %s.\n", chore,
                Thread.currentThread().getName());
    }
}
