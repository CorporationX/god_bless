package school.faang;


public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String piu = "Piu";
        String bum = "Bum";
        String viu = "Viu";

        String piuEffect = "Bullet doing piu piu piu piu piu";
        String bumEffect = "Explosion bum bum bum bum bum";
        String viuEffect = "Going faster viu viu viu viu";

        spellCaster.cast(piu, (spellName) -> spellName + " Action : piu piu piu ", (effect) ->  piuEffect);
        spellCaster.cast(bum, (spellName) -> spellName + " Action : the shield activated ", (effect) ->  bumEffect);
        spellCaster.cast(viu, (spellName) -> spellName + " Action : spell go back by ", (effect) ->  viuEffect);

    }
}
