package school.faang.bjs2_71692;

public class Main{
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();

        caster.cast("Fireball", spell -> "Boom by " + spell);
        caster.cast("Lumos", spell -> "Light was created by" + spell);
    }
}
