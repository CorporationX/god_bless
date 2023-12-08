package faang.school.godbless.task_1;

public class BattleTest {
    public static void main(String[] args) {

        Hero Roland = new Hero("Roland", "knights", 550, 2);
        Hero Aisar = new Hero("Aisar", "warlocks", 700, 3);

        Roland.army.put(EnumNameAndAttackIsUnits.ANGEL.getName(), 1);
        Roland.army.put(EnumNameAndAttackIsUnits.PIKEMAN.getName(), 8);
        Roland.army.put(EnumNameAndAttackIsUnits.SWORDMAN.getName(), 4);
        Roland.army.put(EnumNameAndAttackIsUnits.GRIFFIN.getName(), 2);



        Aisar.army.put(EnumNameAndAttackIsUnits.GRIFFIN.getName(), 2);
        Aisar.army.put(EnumNameAndAttackIsUnits.ANGEL.getName(),2);
        Aisar.army.put(EnumNameAndAttackIsUnits.SWORDMAN.getName(),3);

        Battlefield warOfCastle = new Battlefield(Roland, Aisar);
        System.out.println(warOfCastle.battle(Roland,Aisar));

    }
}
