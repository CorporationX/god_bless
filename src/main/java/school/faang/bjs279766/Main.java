package school.faang.bjs279766;

public class Main {
    private static final int AVADA_KEDAVRA_ID = 5;

    public static void main(String[] args) {
        System.out.println("Hello BJS2-79766!");
        final var hogwartsSpell = getHogwartsSpell();
        hogwartsSpell.printAllSpellEvents();

        var spells = hogwartsSpell.getSpellEventsByType(EventType.PROTECTION);
        System.out.println(spells);
        hogwartsSpell.printSpellEventsByType(EventType.PROTECTION);

        var deletedAvadaKedavra = hogwartsSpell.deleteSpellEvent(AVADA_KEDAVRA_ID);
        System.out.println(deletedAvadaKedavra);
        hogwartsSpell.printAllSpellEvents();
    }

    private static HogwartsSpell getHogwartsSpell() {
        final var hogwartsSpell = new HogwartsSpell();
        final var patronus = new SpellEvent(EventType.PROTECTION, "Patronus: Summon a patronus.");
        final var avadaKedavra = new SpellEvent(EventType.ATTACK, "Avada Kedavra: Kill a nemesis.");
        final var protego = new SpellEvent(EventType.PROTECTION, "Protego: Create a shield.");
        hogwartsSpell.addSpellEvent(patronus.getEventType(), patronus.getAction());
        hogwartsSpell.addSpellEvent(avadaKedavra.getEventType(), avadaKedavra.getAction());
        hogwartsSpell.addSpellEvent(protego.getEventType(), protego.getAction());
        return hogwartsSpell;
    }
}
