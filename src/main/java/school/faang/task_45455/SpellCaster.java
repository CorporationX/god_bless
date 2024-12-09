package school.faang.task_45455;

import lombok.Getter;

@Getter
public class SpellCaster {
    private String alohomora = "Alohomora";
    private String lumos = "Lumos";
    private String expelliarmus = "Expelliarmus";

    public void cast(String nameSpell, SpellAction action) {
        String result = action.castSpell(nameSpell);
        System.out.println("Результат заклинания: " + result);
    }
}
