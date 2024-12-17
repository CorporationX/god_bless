package school.faang.sprint2task45647;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAct) {
        if (spellName == null || spellAct == null) {
            System.out.println("Ошибка: Заклинание или действие не может быть null");
            return;
        }

        String result = spellAct.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
}