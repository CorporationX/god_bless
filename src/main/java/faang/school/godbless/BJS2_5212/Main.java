package faang.school.godbless.BJS2_5212;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String spellName = "abra-cadabra";
        spellCaster.cast(spellName, (x) -> spellName);
    }
}
