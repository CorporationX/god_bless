package faang.school.godbless.heroes;



public class BattleField {
    public static void battle(Hero hero1, Hero hero2){
        int power1 = 0;
        int power2 = 0;
        for (var entry: hero1.getArmy().entrySet()){
            power1 = entry.getKey().getDamage() * entry.getValue();
        }
        for (var entry: hero2.getArmy().entrySet()){
            power2 = entry.getKey().getDamage() * entry.getValue();
        }
        power1 += hero1.getLvl() * hero1.getExperience();
        power2 += hero2.getLvl() * hero2.getExperience();


        if (power1 - power2 > 0){
            System.out.println("Hero number 1 won!!!");
        }
        if (power1 - power2 < 0){
            System.out.println("Hero number 2 won!!!");
        }
        if (power1 == power2){
            System.out.println("Draw!");
        }

    }

    public static void main(String[] args) {
        Hero hero1 = new Hero("Name", "fraction", 50,1);
        Angel angel = new Angel("Markus", 5, 40,50,3,23);
        hero1.addCreature(angel, 70);
        Hero hero2 = new Hero("Name", "fraction", 50,1);
        Angel angel2 = new Angel("Liberio", 5, 40,50,3,23);
        hero2.addCreature(angel2, 70);
        BattleField.battle(hero1, hero2);
    }

}
