package school.faang.bjs2_87323;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();

        String hollowPurple = "Hollow Purple";
        String theWorld = "The World";
        String plusUltra = "PLUS ULTRA";

        caster.cast(hollowPurple, spell -> String.format("заклинание %s стирает все на своем пути", spell));
        caster.cast(theWorld, spell -> String.format("заклинание %s останавливает время на 9 секунд", spell));
        caster.cast(plusUltra, spell -> String.format("заклинание %s наносит удар за гранью возможностей", spell));
    }
}
