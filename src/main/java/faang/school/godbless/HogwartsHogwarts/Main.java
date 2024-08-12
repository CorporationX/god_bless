package faang.school.godbless.HogwartsHogwarts;

public class Main {
    public static void main(String[] args) {
        System.out.println(SpellCaster.cast("Алохомора", spellName -> "Заклинание " + spellName + " открыло дверь" ));
        System.out.println(SpellCaster.cast("Люмос", spellName -> "Заклинание " + spellName + " создало свет" ));
        System.out.println(SpellCaster.cast("Экспелиармус", spellName -> "Заклинание " + spellName + " обезоружило противника" ));
    }
}
