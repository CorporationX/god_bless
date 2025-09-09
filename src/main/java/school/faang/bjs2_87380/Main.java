package school.faang.bjs2_87380;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String aberto = "Аберто";
        String accio = "Акцио";
        String alarteAscendare = "Аларте Аскендаре";

        spellCaster.cast(aberto, spellName -> String.format("%s отпирает двери", spellName));
        spellCaster.cast(accio, spellName -> String.format("%s притягивает предметы", spellName));
        spellCaster.cast(alarteAscendare,
                spellName -> String.format("%s подбрасывает предмет в воздух", spellName));
    }

}
