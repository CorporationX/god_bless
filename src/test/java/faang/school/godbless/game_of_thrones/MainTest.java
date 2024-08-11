package faang.school.godbless.game_of_thrones;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MainTest {

    @Test
    @DisplayName("Test for valid flow")
    public void basicTest() {

        HouseRegistry registry = new HouseRegistry(List.of(
                new House("Targaryen", "House Targaryen's sigil is a three-headed red dragon on black."),
                new House("Stark", "House Stark's sigil is a grey direwolf on a white field."),
                new House("Lannister", "House Lannister's sigil is a golden lion on a crimson field."),
                new House("Martell", "House Martell's sigil is a golden spear piercing a blood-red sun.")
        ));

        Optional<String> sigilInfo = registry.getSigilInfo("Targaryen");
        assertEquals(Optional.of("House Targaryen's sigil is a three-headed red dragon on black."), sigilInfo);

        Optional<House> removed = registry.removeHouse("Martell");
        assertEquals("House Martell's sigil is a golden spear piercing a blood-red sun.", removed.get().getSigil());

        registry.addNewHouse(new House("Baratheon", "House Baratheon's sigil is a stag, sometimes modified with a flaming heart"));
        assertEquals("House Baratheon's sigil is a stag, sometimes modified with a flaming heart", registry.getSigilInfo("Baratheon").get());

        assertDoesNotThrow(registry::outputHousesInfo);
        assertDoesNotThrow(registry::removeAllHousesInfo);
        assertEquals(0, registry.getStorage().size());
    }

    @Test
    @DisplayName("Test for exception cases")
    public void exceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new HouseRegistry(List.of()));
        assertThrows(IllegalArgumentException.class, () -> new HouseRegistry(null));

        HouseRegistry registry = new HouseRegistry(List.of(
                new House("Targaryen", "House Targaryen's sigil is a three-headed red dragon on black."),
                new House("Stark", "House Stark's sigil is a grey direwolf on a white field."),
                new House("Lannister", "House Lannister's sigil is a golden lion on a crimson field."),
                new House("Martell", "House Martell's sigil is a golden spear piercing a blood-red sun.")
        ));

        assertThrows(IllegalArgumentException.class, () -> registry.addNewHouse(new House("Targaryen", "House Targaryen's sigil is a three-headed red dragon on black.")));

        assertThrows(IllegalArgumentException.class, () -> registry.removeHouse(null));
        assertEquals(Optional.empty(), registry.removeHouse("Baratheon"));

        assertThrows(IllegalArgumentException.class, () -> registry.getSigilInfo(""));
        assertThrows(NoSuchElementException.class, () -> registry.getSigilInfo("Baratheon").get());

        registry.removeAllHousesInfo();
        assertThrows(IllegalStateException.class, registry::removeAllHousesInfo);
        assertThrows(IllegalStateException.class, registry::outputHousesInfo);
    }
}
