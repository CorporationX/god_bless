package school.faang.task45439;

public class Main {
    public static void main(String[] args) {
        SpellCaster sp = new SpellCaster();

        System.out.println(sp.cast("Lumos", spell -> "A beam of light is created by " + spell));
    }
}
