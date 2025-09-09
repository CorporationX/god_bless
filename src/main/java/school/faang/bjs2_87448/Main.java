package school.faang.bjs2_87448;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();
        caster.cast("Алахомора", spellName -> {
            System.out.println("Произноситься заклинание: " + spellName);
            return "Заклинание открыло магический замок";
        });
    }
}
