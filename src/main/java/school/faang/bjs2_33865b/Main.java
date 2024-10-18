package school.faang.bjs2_33865b;

public class Main {
    public static void main(String[] args){
        SpellCaster2 spellCaster = new SpellCaster2();

        SpellAction2 fireball = (spellName) -> "Casting fire magic!!! " + spellName;
        SpellAction2 healingWave = (spellName) ->"Casting healing magic " + spellName;

        System.out.println(spellCaster.cast("FireBall!!!!!"));
        System.out.println(spellCaster.cast("Healing Wave!!"));
    }
}


