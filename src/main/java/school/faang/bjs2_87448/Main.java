package school.faang.bjs2_87448;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        caster.cast(alohomora, spellName -> ("Дверь открыта при помощи заклинания " + spellName));
        caster.cast(lumos, spellName -> ("Сильный источник света при помощи заклинания " + spellName));
        caster.cast(expelliarmus, spellName -> ("Палочка выпрыгнула из рук при помощи заклинания ") + spellName);
    }
}
