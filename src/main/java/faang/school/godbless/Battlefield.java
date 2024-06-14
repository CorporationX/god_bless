package faang.school.godbless;

public class Battlefield {

    Hero hero1;
    Hero hero2;

    public Battlefield(Hero hero1 , Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int countHero1 = 0;
        int countHero2 = 0;
        for(Creature craeture : hero1.getArmy()){
            countHero1 += craeture.level * craeture.protection * craeture.damage * craeture.quantity;;
        }
        for(Creature craeture : hero2.getArmy()){
            countHero2 += craeture.level * craeture.protection * craeture.damage * craeture.quantity;;
        }
        if(countHero1 < countHero2){
            return hero2;
        } else if ( countHero2 < countHero1) {
            return hero1;
        } else {
            return null;
        }
    }

}