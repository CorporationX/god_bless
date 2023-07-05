package faang.school.godbless.Multitrading2.TamagochiVlad;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TamagotchiVlad {
    private int deviceId;

    public synchronized void play(){
        System.out.println("Vlad Is playing by: " + deviceId);
    }

    public synchronized void feed(){
        System.out.println("Vlad Is feeding by: " + deviceId);
    }

    public synchronized void clean(){
        System.out.println("Vlad Is cleaning by: " + deviceId);
    }

    public synchronized void sleep(){
        System.out.println("Vlad Is sleeping by: " + deviceId);
    }
}
