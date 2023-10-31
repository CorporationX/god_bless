package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    List<TamagotchiVlad> vladList = new ArrayList<>();


    public synchronized void addVlad(TamagotchiVlad vlad){
        vladList.add(vlad);
        System.out.println(vlad.getName() + " add to controller");
    }

    public synchronized void removeVlad(TamagotchiVlad vlad){
        vladList.remove(vlad);
        System.out.println(vlad.getName() + "remove from controller");
    }

    public synchronized void feedAll(){
        vladList.forEach(TamagotchiVlad::feed);
        System.out.println("All Vlads are fed ");
    }

    public synchronized void playAll(){
        vladList.forEach(TamagotchiVlad::play);
        System.out.println("All Vlads played ");
    }

    public synchronized void cleanAll(){
        vladList.forEach(TamagotchiVlad::clean);
        System.out.println("All Vlads cleaned ");
    }

    public synchronized void sleepAll(){
        vladList.forEach(TamagotchiVlad::sleep);
        System.out.println("All Vlads slept ");
    }
}
