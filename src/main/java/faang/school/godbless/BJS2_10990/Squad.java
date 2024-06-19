package faang.school.godbless.BJS2_10990;

import lombok.Getter;

@Getter
public class Squad {
    private int amount;
    private Character character;
    private int squadPower;

    public Squad(int amount, Character character) {
        this.amount = amount;
        this.character = character;
        this.squadPower = character.getPower() * amount;
    }
}
