package faang.school.godbless.sprint4.tamogochiVlad.classes;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>();

    public synchronized void feedAll(){
        tamagotchiVladList
                .forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll(){
        tamagotchiVladList
                .forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll(){
        tamagotchiVladList
                .forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll(){
        tamagotchiVladList
                .forEach(TamagotchiVlad::sleep);
    }

    public void addVlad(TamagotchiVlad vlad){
        tamagotchiVladList.add(vlad);
    }

    public void deleteVlad(TamagotchiVlad vlad){
        tamagotchiVladList.remove(vlad);
    }
}
