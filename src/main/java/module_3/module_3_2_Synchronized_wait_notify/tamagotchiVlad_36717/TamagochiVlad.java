package module_3.module_3_2_Synchronized_wait_notify.tamagotchiVlad_36717;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TamagochiVlad {
    private final String name;

    public synchronized void feed() {
        System.out.println(name + " кушает...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " наелся!");
    }

    public synchronized void play() {
        System.out.println(name + " играет...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " наигрался!");
    }

    public synchronized void clean() {
        System.out.println("Чистим " + name + "...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " начистился!");
    }

    public synchronized void sleep() {
        System.out.println(name + " спит...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " поспал!");
    }
}
