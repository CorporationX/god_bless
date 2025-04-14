package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Левитация", spell -> {
            return spell + " - Вы поднимались в воздух!";
        });
        spellCaster.cast("Авада Кедавра", spell -> {
            return spell + " - Уничтожение! ";
        });
        spellCaster.cast("Экспелиармус", spell -> {
            return spell + " - Оружие было выбито!";
        });
        spellCaster.cast("Патронус", spell -> {
            return spell + " - Призван защитник!";
        });
    }
}