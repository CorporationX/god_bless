package school.faang.spring2.task_45529;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();
        caster.cast("Alohomora", (spell) -> System.out.println("The door is unlocked by " + spell));
        caster.cast("Lumos", (spell) -> System.out.println("A beam of light is created by " + spell));
        caster.cast("Expelliarmus", (spell) -> System.out.println("The opponent is disarmed by " + spell));
    }
}
