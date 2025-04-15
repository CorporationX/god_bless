package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Левитация", spell -> {
            return String.format("%s - Вы поднимались в воздух!", spell);
        });
        spellCaster.cast("Авада Кедавра", spell -> {
            return String.format("%s - Уничтожение! ", spell);
        });
        spellCaster.cast("Экспелиармус", spell -> {
            return String.format("%s - Оружие было выбито!", spell);
        });
        spellCaster.cast("Патронус", spell -> {
            return String.format("%s - Призван защитник!", spell);
        });
    }
}