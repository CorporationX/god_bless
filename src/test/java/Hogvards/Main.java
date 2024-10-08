package Hogvards;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String light = "Light";
        String rainFromFrog = "Rain from frog";
        String wind = "Wind";
spellCaster.cast(light,(spell )-> "The light turned on when applied   "+spell);
spellCaster.cast(rainFromFrog,(spell )-> "The light turned on when applied   "+spell);
spellCaster.cast(wind,(spell )-> "The light turned on when applied   "+spell);

    }

}
