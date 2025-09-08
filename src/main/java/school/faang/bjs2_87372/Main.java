package school.faang.bjs2_87372;

public class Main {
    public static void main(String[] args) {
        SpellCast spellCaster = new SpellCast();
        String callOfFive = "Call of five";
        String shadowCloning = "Shadow cloning";

        spellCaster.cast(callOfFive, (str) -> str);
        spellCaster.cast(shadowCloning, (str) -> str);
    }
}
