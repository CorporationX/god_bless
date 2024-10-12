package hogwartsHogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Алохоморе", spell -> "Дверь открылась от %s.".formatted(spell.toLowerCase()));
        spellCaster.cast("Люмус", spell -> "Яркий свет от %s.".formatted(spell.toLowerCase()));
        spellCaster.cast("Экспелиармус", spell -> "Все дементры улетели из-за заклинания %s.".formatted(spell.toLowerCase()));
    }
}
