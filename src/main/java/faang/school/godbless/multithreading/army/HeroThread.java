package faang.school.godbless.multithreading.army;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HeroThread extends Thread{
    private final Hero hero;
    private int power;

    @Override
    public void run() {
        this.power = hero.getPower();
    }
}
