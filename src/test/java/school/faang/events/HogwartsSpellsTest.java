package school.faang.events;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static school.faang.events.SpellEventType.CHARM;
import static school.faang.events.SpellEventType.DEFENSE;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
class HogwartsSpellsTest {

    private final HogwartsSpells hogwartsSpells = new HogwartsSpells();

    @AfterEach
    void tearDown() {
        hogwartsSpells.getSpellById().clear();
        hogwartsSpells.getSpellByType().clear();
    }

    @Nested
    class AddSpellEventTest {

        @Test
        void givenUnknownSpellEventType_thenDoNothing() {
            hogwartsSpells.addSpellEvent("UnknownType", "something");
            assertThat(hogwartsSpells.getSpellById())
                    .isEmpty();
            assertThat(hogwartsSpells.getSpellByType())
                    .isEmpty();
        }

        @Test
        void givenExistingSpellEventType_thenAddSpellEvent() {
            hogwartsSpells.addSpellEvent(CHARM.getValue(), CHARM.getDescription());
            assertThat(hogwartsSpells.getSpellById())
                    .isNotEmpty();
            assertThat(hogwartsSpells.getSpellByType())
                    .isNotEmpty();
        }
    }

    @Nested
    class GetSpellEventByIdTest {

        @Test
        void givenNotExistingSpellEventId_thenReturnEmptySpellEvent() {
            assertThat(hogwartsSpells.getSpellEventById(0))
                    .isEqualTo(SpellEvent.EMPTY);
        }

        @Test
        void givenExistingSpellEventId_thenReturnSpellEvent() {
            hogwartsSpells.addSpellEvent(CHARM.getValue(), CHARM.getDescription());
            assertThat(hogwartsSpells.getSpellEventById(0))
                    .isEqualTo(hogwartsSpells.getSpellEventById(0));
        }
    }

    @Nested
    class GetSpellEventsByTypeTest {

        @Test
        void givenUnknownSpellEventType_thenReturnEmptyList() {
            assertThat(hogwartsSpells.getSpellEventsByType("UnknownType"))
                    .isEmpty();
        }

        @Test
        void givenExistingSpellEventType_thenReturnEmptyList() {
            assertThat(hogwartsSpells.getSpellEventsByType(CHARM.getValue()))
                    .isEmpty();
        }

        @Test
        void givenExistingSpellEventType_thenReturnSpellEventList() {
            hogwartsSpells.addSpellEvent(CHARM.getValue(), CHARM.getDescription());
            assertThat(hogwartsSpells.getSpellEventsByType(CHARM.getValue()))
                    .isNotEmpty();
        }
    }

    @Nested
    class DeleteSpellEventTest {

        @Test
        void givenUnknownSpellEventId_thenDoNothing() {
            hogwartsSpells.addSpellEvent(CHARM.getValue(), CHARM.getDescription());
            hogwartsSpells.deleteSpellEvent(1);
            assertThat(hogwartsSpells.getSpellById())
                    .hasSize(1);
        }

        @Test
        void givenExistingSpellEventId_thenDeleteSpellEvent() {
            hogwartsSpells.addSpellEvent(CHARM.getValue(), CHARM.getDescription());
            hogwartsSpells.addSpellEvent(CHARM.getValue(), CHARM.getDescription() + 2);
            hogwartsSpells.deleteSpellEvent(1);
            assertThat(hogwartsSpells.getSpellById())
                    .hasSize(1);
            assertThat(hogwartsSpells.getSpellByType().get(CHARM.getValue()))
                    .hasSize(1);
        }

        @Test
        void givenExistingSpellEventId_thenDeleteSpellEventTypeList() {
            hogwartsSpells.addSpellEvent(CHARM.getValue(), CHARM.getDescription());
            hogwartsSpells.deleteSpellEvent(0);
            assertThat(hogwartsSpells.getSpellById())
                    .isEmpty();
            assertThat(hogwartsSpells.getSpellByType().get(CHARM.getValue()))
                    .isNull();
        }
    }
}