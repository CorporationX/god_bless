package faang.school.godbless.HogwartsHogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        SpellAction spellActionImpl = new SpellActionImpl();
        SpellAction spellAction = (spell) -> System.out.println("Убить всех " + spell);
        //Consumer<String> consumer = (spell) -> System.out.println("Consumer" + spell);
        //Пусть здесь останутся все способы написания лямбды
        spellCaster.cast("avadakedavra", spellAction);
        spellCaster.cast("avadakedavra", (spell) -> System.out.println("Убить всех " + spell));
        spellCaster.cast("avadakedavra", new SpellAction() {
            @Override
            public void doIt(String spell) {
                System.out.println("Убить всех " + spell);
            }
        });

        spellCaster.cast("avadakedavra", spellActionImpl);
        //spellCaster.cast("avadakedavra", consumer);
    }
}
