package Sprint_4_Task18;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class VladController {
    List<TamagotchiVlad> tamagotchiVladList;

    public VladController() {
        this.tamagotchiVladList = new ArrayList<>();
    }

    public void feedAll(){
        tamagotchiVladList.forEach(TamagotchiVlad::feed);
    }
    public void playAll(){
        tamagotchiVladList.forEach(TamagotchiVlad::play);
    }
    public void cleanAll(){
       tamagotchiVladList.forEach(TamagotchiVlad::clean);
    }
    public void sleepAll(){
        tamagotchiVladList.forEach(TamagotchiVlad::sleep);
    }
    public synchronized void addTamagotchiVladList(TamagotchiVlad tamagotchiVlad){
       tamagotchiVladList.add(tamagotchiVlad);
    }
    public synchronized void removeTamagotchiVladList(TamagotchiVlad tamagotchiVlad){
        if (tamagotchiVladList.contains(tamagotchiVlad)){
            tamagotchiVladList.remove(tamagotchiVlad);
        }else {
            System.out.println("TamagotchiVlad not found");
        }
    }

}
