package school.faang.task139;

public class Main {
    public static void main(String[] args) {
        Pikeman firstHeroPikeMan = new Pikeman();
        Pikeman secondHeroPikeMan = new Pikeman();

        Griffin firstHeroGriffin = new Griffin();
        Griffin secondHeroGriffin = new Griffin();

        Swordman firstHeroSwordman = new Swordman();
        Swordman secondHeroSwordman = new Swordman();

        Angel firstHeroAngel = new Angel();

        Hero firstHero = new Hero("Julia", "People", 0, 1);
        Hero secondHero = new Hero("Albert", "People", 0, 1);

        firstHero.addCreature(firstHeroAngel, 2);
        firstHero.addCreature(firstHeroSwordman, 54);
        firstHero.addCreature(firstHeroGriffin, 35);
        firstHero.addCreature(firstHeroPikeMan, 120);

        secondHero.addCreature(secondHeroGriffin, 65);
        secondHero.addCreature(secondHeroSwordman, 74);
        secondHero.addCreature(secondHeroPikeMan, 150);

        Battlefield battlefield = new Battlefield(firstHero, secondHero);
        battlefield.battle();
    }
}
