package school.faang.bjs2_33865;

public class Main {
    public static void main(String[] args){
        SpellCaster spellCaster = new SpellCaster();

        SpellAction fireball = (spellName) -> "Casting fire magic!!! " + spellName;
        SpellAction healingWave = (spellName) ->"Casting healing magic " + spellName;

        System.out.println(spellCaster.cast("FireBall!!!!!"));
        System.out.println(spellCaster.cast("Healing Wave!!"));
    }
}
