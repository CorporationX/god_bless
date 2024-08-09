package faang.school.godbless.BJS2_18922;

public class Battlefield {

    public static String battle(Hero attacker, Hero defender) {
        String result = checkStartArmy(attacker, defender);

        if(result.isEmpty())
            return startFight(attacker, defender);
        else
            return result;
    }

    private static String checkStartArmy(Hero attacker, Hero defender){
        if (!attacker.hasArmy() && !defender.hasArmy()) {
            return "Ничья";
        } else if (!attacker.hasArmy()) {
            return "Победил " + defender.getName();
        } else if (!defender.hasArmy()) {
            return "Победил " + attacker.getName();
        }

        return "";
    }

    private static String startFight(Hero attacker, Hero defender){
        int attackerDamage = attacker.getArmyPower();
        int defenderDamage = defender.getArmyPower();

        if (attackerDamage == defenderDamage)
           return "Ничья";
        else if (attackerDamage > defenderDamage)
            return "Победил " + attacker.getName();
        else
            return "Победил " + defender.getName();
    }
}
