package faang.school.godbless.army_of_heroes;

import lombok.Getter;

@Getter
public class MyThread extends Thread {

    private final Character character;
    private int sumPower;

    public MyThread(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        sumPower = character.getPower();
    }
}
