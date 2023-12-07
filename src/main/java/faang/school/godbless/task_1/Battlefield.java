package faang.school.godbless.task_1;

public class Battlefield {
    private Hero barbarian;
    private Hero archer;
    public Battlefield(Hero barbarian, Hero archer){
        this.archer = archer;
        this.barbarian = barbarian;
    }
    public Hero battle(){
        if(barbarian.allDamage() + barbarian.allDefense() > archer.allDamage() + archer.allDefense()){
            return barbarian;
    } else{
            return archer;
        }
    }

}
