package faang.school.godbless.hogwartshogwartsourbelovedhogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster mySpellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        mySpellCaster.cast(alohomora, (spell) -> String.format("The door is unlocked by %s", spell));
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        SpellAction lumosAction = (spell) -> String.format("A beam of light is created by %s", spell);
        mySpellCaster.cast(lumos, lumosAction);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        mySpellCaster.cast(expelliarmus, (spell) -> String.format("The opponent is disarmed by %s", spell));
    }
}
