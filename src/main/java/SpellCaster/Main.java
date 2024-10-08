package SpellCaster;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String darkWizardName = "Беллатриса Лестрейндж";
        String severusSnegg = "Северус Снегг";
        String avadaKedavra = "АААААВада Кедавра!";
        String sectumSempra = "Сектумсемпра";
        String cruciatus = "Круциатус!";

        spellCaster.cast(avadaKedavra, (spell) -> "Лили Поттер убили заклинанием " + spell);
        spellCaster.cast(sectumSempra, (spell) -> darkWizardName + " замучила родителей Невилла Лонгботтома заклинанием " + cruciatus);
        spellCaster.cast(sectumSempra, (spell) -> severusSnegg + " придумал заклинание " + spell + " для защиты от врагов.");
    }
}
