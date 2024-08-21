package faang.school.godbless;

import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }

    public static <T> T withErrorHandling(Supplier<T> remoteService, ExceptionHandler<T> exceptionHandler) {
        try {
            return remoteService.get();
        } catch (Exception e) {
            return exceptionHandler.onException(e);
        }

    }
}