package faang.school.godbless.tamagochy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Getter
public class VladController implements Runnable{
    private volatile Vector<TamagochiVlad> vladList = new Vector<>();

    public void addTamagochi(TamagochiVlad tamagochiVlad){
        vladList.add(tamagochiVlad);
    }

    public void removeTamagochi(int id){
        synchronized (vladList) {
            vladList.remove(vladList.get(id));
        }
    }

    @Override
    public void run() {
        feedAll();
        playAll();
        cleanAll();
        sleepAll();
    }

    public void feedAll(){
        vladList.forEach(TamagochiVlad::feed);
    }

    public void playAll(){
        vladList.forEach(TamagochiVlad::play);
    }

    public void cleanAll(){
        vladList.forEach(TamagochiVlad::clean);
    }

    public void sleepAll(){
        vladList.forEach(TamagochiVlad::sleep);
    }
}
