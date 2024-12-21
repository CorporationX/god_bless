package school.faang;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        try {
            new User("Oleg", 35, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("", 35, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 17, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 35, "VK", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 35, "Amazon", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
    }
}
