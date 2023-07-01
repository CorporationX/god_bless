package faang.school.godbless.tamagotchi.vlad;

public class TamagotchiVlad {
    public synchronized void feed() {
        System.out.println("Покормили Влада");
    }

    public synchronized void play() {
        System.out.println("Поиграли с Владом");
    }

    public synchronized void clean() {
        System.out.println("Почистили Влада");
    }

    public synchronized void sleep() {
        System.out.println("Уложили Влада спать");
    }
}
