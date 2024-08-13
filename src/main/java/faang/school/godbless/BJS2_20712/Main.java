package faang.school.godbless.BJS2_20712;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Алохомора", spell -> "Заклинание " + spell + " открыло дверь");
        spellCaster.cast("Люмос", spell -> "Заклинание " + spell + " создает свет");
        spellCaster.cast("Экспелиармус", spell -> "Заклинание " + spell + " лишает противника оружия");
    }
}
