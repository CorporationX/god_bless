package faang.school.godbless.task_1;

public class Battlefield {
    public void battle(Hero hero1, Hero hero2) {
        if(hero1.armyHealth() > hero2.armyAttack()){
            System.out.println(hero1.getName() + " победил!");
        }
        else
            System.out.println(hero2.getName() + " победил!");
    }


}
