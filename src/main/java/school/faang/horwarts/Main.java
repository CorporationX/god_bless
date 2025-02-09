package school.faang.horwarts;

public class Main {

    public static void main(String[] args) {
        String avadaKedavra = "Avada Kedavra";
        String expectoPatronum = "Expecto Patronum";

        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(avadaKedavra, (spellAction) -> "The person is murdered by " + avadaKedavra);
        spellCaster.cast(expectoPatronum, (spellName) -> "The person is saved by " + expectoPatronum);
    }
}
