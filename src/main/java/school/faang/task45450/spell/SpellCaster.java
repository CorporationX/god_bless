package school.faang.task45450.spell;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {

        System.out.println("Достал волшебную палочку и готов выполнять заклинание : " + spell);
        action.doAction(spell);
        System.out.println("Убрал волшебную палочку");
        System.out.println("Ожидает результата заклинания " + spell);
        System.out.println("---===---");
    }
}
