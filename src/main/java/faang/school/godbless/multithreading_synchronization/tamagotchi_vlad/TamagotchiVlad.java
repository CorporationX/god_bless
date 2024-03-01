package faang.school.godbless.multithreading_synchronization.tamagotchi_vlad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TamagotchiVlad {
    private String id;
    public synchronized void feed() {
        System.out.println("Кормлю Влада " + getId());
    }

    public synchronized void play() {
        System.out.println("Играю с Владом " + getId());
    }

    public synchronized void clean() {
        System.out.println("Мою Влада " + getId());
    }

    public synchronized void sleep() {
        System.out.println("Укладываю спать Влада " + getId());
    }
}
