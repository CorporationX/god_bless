package faang.school.godbless.task18990;



public class Battlefield {
    public String battle (Hero hero1, Hero hero2){
        int damageOfArmy1 = hero1.getArmy().stream().map(Creature::getDamage).mapToInt(Integer::intValue).sum();
        int damageOfArmy2 = hero2.getArmy().stream().map(Creature::getDamage).mapToInt(Integer::intValue).sum();

        if(damageOfArmy1 > damageOfArmy2) {    // Победившему герою повышается опыт +1 и уровень +1
            hero1.setExperience(hero1.getExperience() + 1);
            hero1.setLevel(hero1.getLevel() + 1);
        } else {hero2.setExperience(hero2.getExperience() + 1);
            hero2.setLevel(hero2.getLevel() + 1);
        }
        return damageOfArmy1 > damageOfArmy2 ? hero1.getFraction() : hero2.getFraction();
    }
}
