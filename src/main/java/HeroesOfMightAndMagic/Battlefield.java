package HeroesOfMightAndMagic;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;
    private int moveCounter;

    public void battle() {
        // создаем героев
        hero1 = new Hero("Player1", "Castle", 100, 10);
        hero2 = new Hero("Player2", "Tower", 100, 10);

        // наполняем армии
        int magicNumber;
        Creature creature = null;
        for (int i = 0; i < 20; i++) {
            magicNumber = (int) (Math.random() * 4);
            switch (magicNumber) {
                case 0:
                    creature = new Swordman();
                    break;
                case 1:
                    creature = new Pikeman();
                    break;
                case 2:
                    creature = new Griffin();
                    break;
                case 3:
                    creature = new Angel();
                    break;
            }
            if (i < 10){
                hero1.addCreature(creature, 1);
            } else {
                hero2.addCreature(creature, 1);
            }
        }

        //Устанавливаем счетчик ходов
        moveCounter = 0;

        //Создаем переменные для Атакующих/Защищающихся и урона
        Hero attackHero;
        Hero defenceHero;
        Creature attackCreature;
        Creature defenceCreature;
        int damage;

        System.out.println(hero1.getArmy());
        System.out.println(hero2.getArmy());

        // ЦИКЛ (пока во всех армиях есть хотя бы 1 живое существо)
        while (true) {

            if (hero1.getCurrentArmySize() <= 0 || hero2.getCurrentArmySize() <= 0){
                break;
            }

            // ПО ОЧЕРЕДИ Выбираем атакующего/защищающегося:
            if (moveCounter % 2 == 0){
                attackHero = hero1;
                defenceHero = hero2;
                // определяем атакующее существо
                attackCreature = attackHero.getArmy().get((int) (Math.random() * attackHero.getCurrentArmySize()));
                // определяем атакуемое существо
                defenceCreature = defenceHero.getArmy().get((int) (Math.random() * defenceHero.getCurrentArmySize()));
            } else {
                attackHero = hero2;
                defenceHero = hero1;
                // определяем атакующее существо
                attackCreature = attackHero.getArmy().get((int) (Math.random() * attackHero.getCurrentArmySize()));
                // определяем атакуемое существо
                defenceCreature = defenceHero.getArmy().get((int) (Math.random() * defenceHero.getCurrentArmySize()));
            }
            // вычисляем наносимый урон
            damage = attackCreature.getDamage() - defenceCreature.getDefence();

            // наносим урон
            // ЕСЛИ урон >= ХП - существо умерло - удаляем из списка
            if (damage >= defenceCreature.getHealth()){
                defenceHero.removeCreature(defenceCreature, 1);
            } else {
                defenceCreature.setHealth(defenceCreature.getHealth() - damage);
            }
            moveCounter++;
        }
        // Выводим сообщение о победителе
        if (hero1.getCurrentArmySize() == 0){
            System.out.println("Player2 won!");
        } else {
            System.out.println("Player1 won!");
        }
    }
}
