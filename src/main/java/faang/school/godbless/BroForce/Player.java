package faang.school.godbless.BroForce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player implements Runnable {
    private final String name;
    private int live;
    private boolean alive = true;

    public Player(String name, int live) {
        this.name = name;
        this.live = live;
    }

    // почему-то не срабатывает метод run()
    @Override
    public void run() {
        System.out.println("Что-то делаем");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Все прервано...");
        }
        live--;
        System.out.println("Оставшееся количество жизней у игрока " + this.getName() + ": " + this.getLive());
    }

}
