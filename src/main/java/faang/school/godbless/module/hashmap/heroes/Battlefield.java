package faang.school.godbless.module.hashmap.heroes;

import faang.school.godbless.module.hashmap.heroes.hero.Hero;

public class Battlefield {
    private Hero firstPlayer;
    private Hero secondPlayer;
    
    public Battlefield(Hero firstPlayer, Hero secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }
    
    public Hero battle() {
        int firstPlayerDamagePoints = getDamagePoints(firstPlayer);
        int secondPlayerDefencePoints = getDefencePoints(secondPlayer);
        if (firstPlayerDamagePoints > secondPlayerDefencePoints) {
            return firstPlayer;
        }
        return secondPlayer;
    }
    
    private int getDamagePoints(Hero hero) {
        int damagePoints = 0;
        for (var entry : hero.getArmy().entrySet()) {
            damagePoints += entry.getKey().getDamage() * entry.getValue();
        }
        return damagePoints;
    }
    
    private int getDefencePoints(Hero hero) {
        int defencePoints = 0;
        for (var entry : hero.getArmy().entrySet()) {
            defencePoints += entry.getKey().getDefence() * entry.getValue();
        }
        return defencePoints;
    }
}
