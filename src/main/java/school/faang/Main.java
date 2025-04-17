package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
=======
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("До разворота: " + Arrays.toString(nums));
        Example.reverse(nums);
        System.out.println("После разворота: " + Arrays.toString(nums));
    }
}
