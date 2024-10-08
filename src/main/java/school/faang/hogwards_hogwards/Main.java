package school.faang.hogwards_hogwards;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String name = "Poki";
        String fire = "Fire";
        spellCaster.cast(name, cast -> "Trah tibidoh " + cast);
        spellCaster.cast(fire, cast -> "My god " + cast);
        spellCaster.cast(name, cast -> cast + ", you is dead!");
    }
}
