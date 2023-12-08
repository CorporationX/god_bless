package faang.school.godbless;

public class Battlefield {

    public Hero hero1;
    public Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }


    //решил самым простым способом, потому что хочется решить другие задачи
    public String battle(){
            if(hero1.getArmy().isEmpty()) return "win hero 2";
            if(hero2.getArmy().isEmpty()) return"win hero 1";
        Long damageHero1 = 0l;
        Long damageHero2 = 0l;
        Long defenseHero1 = 0l;
        Long defenseHero2 = 0l;
        for(Creature h :hero1.getArmy()){
            damageHero1 = damageHero1+h.Damage;
            defenseHero1 = defenseHero1+h.Defense;
        }
        for(Creature h :hero2.getArmy()){
            damageHero2 = damageHero2+h.Damage;
            defenseHero2 = defenseHero2+h.Defense;
        }
        if(defenseHero1-damageHero2==defenseHero2-damageHero1) return"Friendship won";
        if(defenseHero1-damageHero2<defenseHero2-damageHero1){
            return"Win hero 2";
        }else
            return"Win hero 1";






    }

}
