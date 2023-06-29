package faang.school.godbless.DiversificationHeroesOfMagic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Count extends Thread{

    private int power;
    private Character character;

    public Count(Character character){
        this.character = character;
    }

    @Override
    public void run() {
        setPower(character.getPower());
    }
}
