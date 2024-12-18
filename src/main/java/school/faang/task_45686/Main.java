package school.faang.task_45686;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String attack = "Атака";
        String shield = "Щит";
        String fireball = "Фаербол";

        spellCaster.cast(attack, (spell) -> "Вы использовали заклинание " + spell + ". Отличный удар!");
        spellCaster.cast(shield, (spell) -> "Вы использовали заклинание " + spell);
        spellCaster.cast(fireball, (spell) -> "Вы использовали заклинание " + spell + ". Вы попали в цель");
    }
}
