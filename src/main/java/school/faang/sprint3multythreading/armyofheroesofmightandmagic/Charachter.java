package school.faang.sprint3multythreading.armyofheroesofmightandmagic;

import lombok.Getter;

@Getter
public abstract class Charachter {
    private final int power;

    public Charachter(int power) {
        this.power = power;
    }
}
