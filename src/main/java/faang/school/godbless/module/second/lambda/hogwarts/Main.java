package faang.school.godbless.module.second.lambda.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        
        spellCaster.cast(alohomora, (spell) -> System.out.println("The door is unlocked by " + spell));
        spellCaster.cast(lumos, (spell) -> System.out.println("A beam of light is created by " + spell));
        spellCaster.cast(expelliarmus, (spell) -> System.out.println("The opponent is disarmed by " + spell));
    }
}
