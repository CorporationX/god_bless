package faang.school.godbless.normal_game;

import lombok.Data;

@Data
public class PigThread extends Thread {
    private String pigName;
    private String material;

}

class Pig1Thread extends PigThread {
    @Override
    public void run() {
        setPigName("Ниф-Ниф");
        setMaterial("солома");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Домик построил " + getPigName() + " из материала " + getMaterial());
    }
}

class Pig2Thread extends PigThread {
    @Override
    public void run() {
        setPigName("Нуф-Нуф");
        setMaterial("палки");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Домик построил " + getPigName() + " из материала " + getMaterial());
    }
}

class Pig3Thread extends PigThread {
    @Override
    public void run() {
        setPigName("Наф-Наф");
        setMaterial("кирпичи");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Домик построил " + getPigName() + " из материала " + getMaterial());
    }
}

