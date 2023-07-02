package faang.school.godbless.Sprint4.VladToy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TamagotchiVlad {
    private String name;
    public synchronized void feed() throws InterruptedException {
        System.out.println(name+" is eating");
        Thread.sleep(3000);
    }
    public synchronized void play() throws InterruptedException {
        System.out.println(name+" is playing");
        Thread.sleep(5000);
    }
    public synchronized void clean() throws InterruptedException {
        System.out.println(name+" is cleaning");
        Thread.sleep(5000);
    }
    public synchronized void sleep() throws InterruptedException {
        System.out.println(name+" is sleeping");
    }
}
