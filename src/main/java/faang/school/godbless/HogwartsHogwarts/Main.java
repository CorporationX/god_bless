package faang.school.godbless.HogwartsHogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        SpellAction spellAction = (spell) -> System.out.println("Убить всех первый раз " + spell);
        //Пусть здесь останутся все способы написания лямбды
        spellCaster.cast("avadakedavra", spellAction);
        spellCaster.cast("avadakedavra", (spell) -> System.out.println("Убить всех второй раз " + spell));
        spellCaster.cast("avadakedavra", new SpellAction() {
            @Override
            public void doIt(String spell) {
                System.out.println("Убить всех третий раз " + spell);
            }
        });
    }
}
