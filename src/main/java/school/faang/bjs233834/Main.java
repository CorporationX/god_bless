package school.faang.bjs233834;

public class Main {
    public static void main(String[] args) {
        SpellCaster alohomora = new SpellCaster();
        SpellCaster expelliarmus = new SpellCaster();
        SpellCaster expectoPatronum = new SpellCaster();

        alohomora.cast("Alohomora", spell -> spell + ": the door opened!");
        expelliarmus.cast("Expelliarmus", spell -> spell);
        expectoPatronum.cast("Expecto Patronum", spell -> spell + ": your Patronus came!");
    }
}
