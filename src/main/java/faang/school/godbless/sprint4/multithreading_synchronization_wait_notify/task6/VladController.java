package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task6;

import java.util.ArrayList;
import java.util.List;

public class VladController {

    private List<TamagotchiVlad> tamagotchis = new ArrayList<>();

    public synchronized void feedAll(){
        tamagotchis.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll(){
        tamagotchis.forEach(TamagotchiVlad::play);
    }

    public synchronized void sleepAll(){
        tamagotchis.forEach(TamagotchiVlad::sleep);
    }

    public synchronized void cleanAll(){
        tamagotchis.forEach(TamagotchiVlad::clean);
    }

    public void addTamagotchi(TamagotchiVlad tamagotchi){
        tamagotchis.add(tamagotchi);
    }

    public void deleteTamagotchi(TamagotchiVlad tamagotchi){
        tamagotchis.remove(tamagotchi);
    }

}
