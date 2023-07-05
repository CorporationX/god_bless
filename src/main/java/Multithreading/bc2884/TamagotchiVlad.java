package Multithreading.bc2884;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TamagotchiVlad {
    private int id;

    public synchronized void feed(){
        System.out.println("Vlad is eating");
    }
    public synchronized void play(){
        System.out.println("Vlad is playing");
    }
    public synchronized void clean(){
        System.out.println("Vlad has been cleaned");
    }
    public synchronized void sleep(){
        System.out.println("Vlad is sleeping");
    }

}
