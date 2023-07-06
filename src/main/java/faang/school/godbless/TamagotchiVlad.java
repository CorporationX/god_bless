package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TamagotchiVlad {
    private String name;
    public synchronized void feed(){
        System.out.println("Vlad " + getName() + " is feeding ...");
    }

    public synchronized void play(){
        System.out.println("Vlad " + getName() + " is playing ...");
    }
    public synchronized void clean(){
        System.out.println("Vlad " + getName() + "is cleaning ...");
    }
    public synchronized void sleep(){
        System.out.println("Vlad " + getName() + " is sleeping ...");
    }
}
