package faang.school.godbless.tamagochy;

import lombok.Getter;

@Getter
public class TamagochiVlad {
    private int id;
    private boolean isFeed;
    private boolean isPlayed;
    private boolean isClean;
    private boolean isSleep;

    public TamagochiVlad(int id) {
        this.id = id;
    }

    public synchronized void feed(){
        if(!isFeed) {
            System.out.println("Тамагочи-Влад №" + id + " покормлен.");
            isFeed = true;
        }
    }

    public synchronized void play(){
        if(!isPlayed) {
            System.out.println("Играем с Тамагочи_Владом №" + id);
            isPlayed = true;
        }
    }

    public synchronized void clean(){
        if(!isClean) {
            System.out.println("Моем Тамагочи-Влада №" + id);
            isClean = true;
        }
    }

    public synchronized void sleep(){
        if(!isSleep) {
            System.out.println("Укладываем спать Тамагочи-Влада №" + id);
            isSleep = true;
        }
    }
}
