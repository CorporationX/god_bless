package school.faang.m1.bjs2_33754_hogwarts;

public class Main {

    public static void main(String[] args) {
        SpellCaster voldemort = new SpellCaster();
        SpellCaster harry = new SpellCaster();

        String firaga = "Firaga";
        SpellAction drainBlood = (spell) -> "The enemy's blood is drained with " + spell;

        SpellAction heal = (spell) -> "The mage is healed with " + spell;
        SpellAction damage = (spell) -> "The mage is damaged with " + spell;

        voldemort.cast("Armageddona", (s) -> "The city is destroyed with " + s);
        voldemort.cast(firaga, (spell) -> "The enemy is burned to ashes with " + spell);
        voldemort.cast("DrainBloodus", drainBlood);

        harry.cast("Healus", heal);
        harry.cast("Curatus", heal);
        harry.cast("Fireball", damage);
        harry.cast("Lightning", damage);
    }
}
