package faang.school.godbless.task_1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Battlefield {

    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero attacker, Hero defender) {
        this.hero1 = attacker;
        this.hero2 = defender;
    }

     public Hero battle(Hero attacker, Hero defender){
        int attackerStrongArmy = Hero.StrongArmy(hero1);
        int defenderStrongArmy = Hero.StrongArmy(hero2);
        return attackerStrongArmy > defenderStrongArmy ? hero1 : hero2;
     }
}




