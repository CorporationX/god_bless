package school.faang.task_44688;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HogwartsSpellsTest {
    private HogwartsSpells hogwartsSpells;

    @BeforeEach
    void setUp() {
        SpellEvent.resetCounter();
        hogwartsSpells = new HogwartsSpells();
    }

    @Test
    @DisplayName("addSpellEvent: valid inputs adds event successfully")
    void addSpellEvent_validInputs_addsEventSuccessfully() {
        // Arrange
        String eventType = "Attack";
        String actionDescription = "Casts a powerful fireball";

        // Act
        hogwartsSpells.addSpellEvent(eventType, actionDescription);

        // Assert
        assertAll("Add spell",
                () -> assertEquals(1, hogwartsSpells.getSpellEventById(1).getId(),
                        "Spell ID mismatch"),
                () -> assertEquals(eventType, hogwartsSpells.getSpellEventById(1).getEventType(),
                        "Event type mismatch"),
                () -> assertNotNull(hogwartsSpells.getSpellEventsByType(eventType),
                        "Event type list should not be null")
        );
    }

    @Test
    @DisplayName("addSpellEvent: null or blank inputs throws exception")
    void addSpellEvent_nullOrBlankInputs_throwsException() {
        // Arrange
        String eventType = null;
        String actionDescription = "Casts a powerful fireball";

        // Act & Assert
        assertAll("Invalid inputs",
                () -> assertThrows(IllegalArgumentException.class, () ->
                                hogwartsSpells.addSpellEvent(eventType, actionDescription),
                        "Null event type should throw exception"),

                () -> assertThrows(IllegalArgumentException.class, () ->
                                hogwartsSpells.addSpellEvent("", actionDescription),
                        "Blank event type should throw exception"),

                () -> assertThrows(IllegalArgumentException.class, () ->
                                hogwartsSpells.addSpellEvent("Attack", null),
                        "Null action description should throw exception"),

                () -> assertThrows(IllegalArgumentException.class, () ->
                                hogwartsSpells.addSpellEvent("Attack", ""),
                        "Blank action description should throw exception")
        );
    }

    @Test
    @DisplayName("getSpellEventById: valid ID returns spell")
    void getSpellEventById_validId_returnsSpell() {
        // Arrange
        hogwartsSpells.addSpellEvent("Defense", "Casts a protective shield");

        // Act
        SpellEvent spell = hogwartsSpells.getSpellEventById(1);

        // Assert
        assertAll("Get spell by ID",
                () -> assertNotNull(spell, "Spell should not be null"),
                () -> assertEquals(1, spell.getId(), "ID mismatch"),
                () -> assertEquals("Defense", spell.getEventType(), "Event type mismatch")
        );
    }

    @Test
    @DisplayName("getSpellEventById: invalid ID returns null")
    void getSpellEventById_invalidId_returnsNull() {
        // Act
        SpellEvent spell = hogwartsSpells.getSpellEventById(999);

        // Assert
        assertNull(spell, "Spell should be null for invalid ID");
    }

    @Test
    @DisplayName("getSpellEventsByType: valid type returns list of spells")
    void getSpellEventsByType_validType_returnsListOfSpells() {
        // Arrange
        hogwartsSpells.addSpellEvent("Attack", "Casts fireball");
        hogwartsSpells.addSpellEvent("Attack", "Casts lightning");

        // Act
        List<SpellEvent> spells = hogwartsSpells.getSpellEventsByType("Attack");

        // Assert
        assertAll("Get spells by type",
                () -> assertEquals(2, spells.size(), "Spell count mismatch"),
                () -> assertEquals("Attack", spells.get(0).getEventType(), "Event type mismatch"),
                () -> assertEquals("Attack", spells.get(1).getEventType(), "Event type mismatch")
        );
    }

    @Test
    @DisplayName("getSpellEventsByType: invalid type throws exception")
    void getSpellEventsByType_invalidType_throwsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                        hogwartsSpells.getSpellEventsByType("NonExistentType"),
                "Invalid event type should throw exception");
    }

    @Test
    @DisplayName("deleteSpellEvent: valid ID removes spell")
    void deleteSpellEvent_validId_removesSpell() {
        // Arrange
        hogwartsSpells.addSpellEvent("Block", "Blocks incoming attacks");

        // Act
        hogwartsSpells.deleteSpellEvent(1);

        // Assert
        assertAll("Delete spell by ID",
                () -> assertNull(hogwartsSpells.getSpellEventById(1), "Spell should be null after deletion"),
                () -> assertThrows(IllegalArgumentException.class, () ->
                        hogwartsSpells.getSpellEventsByType("Block"), "Type should no longer exist")
        );
    }

    @Test
    @DisplayName("deleteSpellEvent: invalid ID throws exception")
    void deleteSpellEvent_invalidId_throwsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                hogwartsSpells.deleteSpellEvent(999), "Invalid ID should throw exception");
    }

    @Test
    @DisplayName("printAllSpellEvents: empty collection throws exception")
    void printAllSpellEvents_emptyCollection_throwsException() {
        // Act & Assert
        assertThrows(IllegalStateException.class, hogwartsSpells::printAllSpellEvents,
                "Empty collection should throw exception");
    }
}