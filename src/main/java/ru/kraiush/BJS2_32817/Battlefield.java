package ru.kraiush.BJS2_32817;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public Hero battle() {
        int sumDamageOfAttacker = 0;
        int sumDamageOfDefender = 0;
        for (Creature creature : attacker.getArmy()) {
            sumDamageOfAttacker += creature.getDamage();
        }
        for (Creature creature : defender.getArmy()) {
            sumDamageOfDefender += creature.getDamage();
        }
        return sumDamageOfAttacker > sumDamageOfDefender ? attacker : defender;
    }
}
