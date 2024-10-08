package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String abrakadabra = "Abrakadabra";
        String avadakedabra = "Avadakedabra";
        String akcio = "Akcio";

        spellCaster.cast(abrakadabra, (spellName -> "Произойдет не пойми что"));
        spellCaster.cast(avadakedabra, (spellName -> "Создание умертвится"));
        spellCaster.cast(akcio, (spellName -> "Предмет подлетит к волшебнику"));
    }
}
