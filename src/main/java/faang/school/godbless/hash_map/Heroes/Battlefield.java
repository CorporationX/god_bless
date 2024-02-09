package faang.school.godbless.hash_map.Heroes;

import java.util.Random;

public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public Battlefield(Hero attacker, Hero defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Hero battle(){  // Сама реализация боя не лучшая, первое что пришло в голову
        while (!attacker.isDefeat() && !defender.isDefeat()){
            int whoAttacker = new Random().nextInt(attacker.getArmy().size()); // Выбираем рандомно
            int whoDefender = new Random().nextInt(defender.getArmy().size()); // атакующих и защитников
            Creature creatureAttacker = attacker.getArmy().get(whoAttacker);
            Creature creatureDefender = defender.getArmy().get(whoDefender);
            boolean battleResult = attack(creatureAttacker, creatureDefender);
            if(battleResult){
                defender.removeCreature(creatureDefender);
            } else {
                attacker.removeCreature(creatureAttacker);
            }
        }
        if(attacker.isDefeat()){
            return defender;
        }else {
            return attacker;
        }
    }

    private static boolean attack(Creature attacker, Creature defender){
        int damageDefender = (defender.getDamage() * defender.getCount()) - (attacker.getCount() * attacker.getDefense());
        int damageAttack = (defender.getDamage() * defender.getCount()) - (defender.getCount() * defender.getDefense());
        if(damageAttack > damageDefender){ // Кто больше урона своей армией нанесет, тот и победит в этом поединке
            attacker.setCount((int) (attacker.getCount() * 0.5)); // грубо представим что после битвы, погибло половина
            return true;
        }else {
            defender.setCount((int) (defender.getCount() * 0.5));
            return false;
        }
    }
}
