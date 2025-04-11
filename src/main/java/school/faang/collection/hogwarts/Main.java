package school.faang.collection.hogwarts;

import lombok.extern.slf4j.Slf4j;
import school.faang.collection.hogwarts.spell.SpellType;

import java.util.NoSuchElementException;
import java.util.Objects;

@Slf4j
public class Main {

    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent(SpellType.DEFENCE, "Патронус - защита от дементора");
        HogwartsSpells.addSpellEvent(SpellType.CURSE, "Круциатус - Грюм на паука");
        HogwartsSpells.addSpellEvent(SpellType.ATTACK, "Авадакидавра!? (Грюм на паука)");
        HogwartsSpells.addSpellEvent(SpellType.TRANSFIGURATION, "Крыса в стакан");
        HogwartsSpells.addSpellEvent(SpellType.ATTACK, "Остолбеней - дуэли");
        HogwartsSpells.addSpellEvent(SpellType.TRANSFIGURATION, "Стакан в крысу");
        HogwartsSpells.addSpellEvent(SpellType.DEFENCE, "Патронус - опять защита от дементора");
        HogwartsSpells.addSpellEvent(SpellType.TRANSFIGURATION, "Крыса в стакан");
        HogwartsSpells.addSpellEvent(SpellType.DEFENCE, "Патронус - снова защита от дементора");
        HogwartsSpells.addSpellEvent(SpellType.ATTACK, "Остолбеней - дуэли");

        log.info(Objects.requireNonNull(HogwartsSpells.getSpellEventById(5)).toString());
        log.info(HogwartsSpells.getSpellEventsByType(SpellType.ATTACK).toString());

        HogwartsSpells.printAllEvents();

        HogwartsSpells.deleteSpellEvent(1);
        HogwartsSpells.deleteSpellEvent(4);

        HogwartsSpells.printAllEvents();

        try {
            HogwartsSpells.deleteSpellEvent(11);
        } catch (NoSuchElementException e) {
            log.info("Cant delete spell event with id {}", 11);
        }

        try {
            HogwartsSpells.getSpellEventById(12);
        } catch (NoSuchElementException e) {
            log.info("Event with id {} not found", 12);
        }

        log.info(HogwartsSpells.getSpellEventsByType(SpellType.ATTACK).toString());
    }
}