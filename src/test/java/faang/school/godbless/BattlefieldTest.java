package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattlefieldTest {
    private Battlefield battlefield;
    private Hero firstHero;
    private Hero secondHero;
    private Pikeman pikeman;
    private Griffin griffin;
    private Swordman swordman;
    private Angel angel;

    @BeforeEach
    public void setUp(){
        firstHero = new Hero("Zoltan","Light");
        secondHero = new Hero("Goldran","Darkness");

        pikeman = new Pikeman("Pikeman");
        griffin = new Griffin("Griffin");
        swordman = new Swordman("Swordman");
        angel = new Angel("Angel");
    }

    @Test
    public void battleResultDrawTest(){
        firstHero.addCreature(pikeman , 1000);
        firstHero.addCreature(griffin , 500);
        secondHero.addCreature(pikeman , 1000);
        secondHero.addCreature(griffin , 500);

        battlefield = new Battlefield(firstHero , secondHero);
        Hero actualResult = battlefield.battle();


        assertNull(actualResult);
    }

    @Test
    public void battleResultWinnerHero2Test(){

        firstHero.addCreature(pikeman , 1000);
        firstHero.addCreature(griffin , 500);
        secondHero.addCreature(swordman , 2000);
        secondHero.addCreature(angel , 300);

        battlefield = new Battlefield(firstHero , secondHero);
        Hero actualResult = battlefield.battle();


        assertEquals(secondHero,actualResult);
    }

    @Test
    public void battleResultWinnerHero1Test(){

        firstHero.addCreature(pikeman , 1000);
        firstHero.addCreature(griffin , 500);
        secondHero.addCreature(swordman , 1000);
        secondHero.addCreature(angel , 300);

        battlefield = new Battlefield(firstHero , secondHero);
        Hero actualResult = battlefield.battle();


        assertEquals(firstHero,actualResult);
    }
}