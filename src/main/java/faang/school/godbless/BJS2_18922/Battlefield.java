package faang.school.godbless.BJS2_18922;

public class Battlefield {

    public static void battle(Hero attacker, Hero defender){
        //надеюсь тут не надо было просчитывать каж
        if(attacker.getArmy().isEmpty() && defender.getArmy().isEmpty()) {
            System.out.println("Ничья");
        } else if(attacker.getArmy().isEmpty()){
            System.out.println("Победил " + defender.getName());
        } else if(defender.getArmy().isEmpty()){
            System.out.println("Победил " + attacker.getName());
        }

        int attackerDamage = attacker.getArmy().stream().mapToInt(creature -> creature.getDamage()).sum();
        int defenderDamage = defender.getArmy().stream().mapToInt(creature -> creature.getDamage()).sum();

        if(attackerDamage == defenderDamage)
            System.out.println("Ничья");
        else if(attackerDamage > defenderDamage)
            System.out.println("Победил " + attacker.getName());
        else if(defenderDamage > attackerDamage)
            System.out.println("Победил " + defender.getName());
    }
}
