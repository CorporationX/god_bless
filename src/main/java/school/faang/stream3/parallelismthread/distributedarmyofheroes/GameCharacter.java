package school.faang.stream3.parallelismthread.distributedarmyofheroes;

import lombok.Data;

@Data
public abstract class GameCharacter {
    protected int power;

    public GameCharacter(int power) {
        this.power = power;
    }
}
