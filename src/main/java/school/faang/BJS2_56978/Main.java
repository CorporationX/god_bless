package school.faang.BJS2_56978;


public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();
        spells.addSpellEvent(EvantType.ABRACADABRA,
                "основное заклинание, которое используется, чтобы произвести магический эффект или изменение.");
        spells.addSpellEvent(EvantType.RIDDIKULUS,
                "заклинание, которое превращает страшных созданий в смешные или нелепые формы.");
        spells.addSpellEvent(EvantType.RIDDIKULUS,
                "заклинание.");
        spells.printAllSpellEvents();

    }
}
