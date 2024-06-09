package faang.school.godbless.module1.spring1.task8;


import lombok.Getter;

@Getter
public class Swordman extends Creature{

    public Swordman() {
        super();
        this.name = "Swordman";
        this.lvl = 10;
        this.attack = 5;
        this.defense = 15;
        this.speed = 10;
        this.heals = 200;

    }

}
