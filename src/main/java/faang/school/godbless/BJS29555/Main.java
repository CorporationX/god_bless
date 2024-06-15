package faang.school.godbless.BJS29555;

public class Main {
    public static void main(String[] args) {
        SpellCaster heWhoMustNotBeNamed = new SpellCaster();

        heWhoMustNotBeNamed.cast("Avada Kedavra",
                (spell) -> "The opponent is killed instantly by " + spell);
        heWhoMustNotBeNamed.cast("Crucio",
                (spell) -> "The victim is tortured with unbearable pain by " + spell);
        heWhoMustNotBeNamed.cast("Imperio",
                (spell) -> "The victim's will is completely controlled by " + spell);
    }
}
