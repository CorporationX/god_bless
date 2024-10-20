package school.faang.vladtamagochi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Data
public class TamagotchiVlad {
    private final String name;

    public synchronized void feed() {
        System.out.println("Кормим влада " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread hes been interrupted " + e);
        }
        System.out.println(name + " Теперь сыт");
    }

    public synchronized void play() {
        System.out.println("Playing with влад " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread hes been interrupted " + e);
        }
        System.out.println(name + " Наигрался");
    }

    public synchronized void clean() {
        System.out.println("Чистим влада " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread hes been interrupted " + e, e);
        }
        System.out.println(name + " Теперь чистый");
    }

    public synchronized void sleep() {
        System.out.println("Укладываем спать влада");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread hes been interrupted " + e);
        }
        System.out.println(name + " Спит");
    }
}
