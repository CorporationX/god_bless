package school.faang.bjs2_87336;

public class Main {
    public static void main(String[] args) {
        String kira = "Killer Queen";
        String stand = "Star Platinum";

        SpellCaster.cast(kira, (spell) -> "Джотаро и Коичи были поражены способностью " + spell);
        SpellCaster.cast(stand, (spell) -> "Дио был побеждён непобедимым " + spell);
    }
}
