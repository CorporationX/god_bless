package school.faang.BJS2_31295;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CharacterSubclassesTest {
    static Stream<Arguments> characterSubclasses() {
        return Stream.of(
                Arguments.of(Warrior.class, "Anna", 10, 5, 3, 100),
                Arguments.of(Archer.class, "Bob", 3, 10, 5, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("characterSubclasses")
    @DisplayName("Testing the creation of subclass object using constructor with valid name")
    void testConstructorWithValidNameOnly(
            Class<? extends Character> clazz, String name, int expectedPower,
            int expectedAgility, int expectedIntelligence, int expectedHealth
    ) throws Exception {
        Constructor<? extends Character> constructor = clazz.getConstructor(String.class);
        Character character = constructor.newInstance(name);

        assertEquals(name, character.name);
        assertEquals(expectedPower, character.power);
        assertEquals(expectedAgility, character.agility);
        assertEquals(expectedIntelligence, character.intelligence);
        assertEquals(expectedHealth, character.health);
    }

    @ParameterizedTest
    @MethodSource("characterSubclasses")
    @DisplayName("Testing the creation of subclass object using constructor (only name) with empty name")
    void testConstructorWithEmptyNameOnly(Class<? extends Character> clazz) throws Exception {
        String name = "    ";
        Constructor<? extends Character> constructor = clazz.getConstructor(String.class);

        InvocationTargetException invocationException = assertThrows(InvocationTargetException.class,
                () -> constructor.newInstance(name));
        Throwable cause = invocationException.getCause();
        assertEquals(IllegalArgumentException.class, cause.getClass());
        assertEquals("Invalid name.", cause.getMessage());
    }

    @ParameterizedTest
    @MethodSource("characterSubclasses")
    @DisplayName("Testing the creation of subclass object using constructor (only name) with null name")
    void testConstructorWithNullNameOnly(Class<? extends Character> clazz) throws Exception {
        String name = null;
        Constructor<? extends Character> constructor = clazz.getConstructor(String.class);

        InvocationTargetException invocationException = assertThrows(InvocationTargetException.class,
                () -> constructor.newInstance(name));
        Throwable cause = invocationException.getCause();
        assertEquals(IllegalArgumentException.class, cause.getClass());
        assertEquals("Invalid name.", cause.getMessage());
    }

    @ParameterizedTest
    @MethodSource("characterSubclasses")
    @DisplayName("Testing the damage given by a character to another character")
    void testCharacterAttack(Class<? extends Character> clazz) throws Exception {
        Constructor<? extends Character> constructor = clazz.getConstructor(String.class);
        Character character1 = constructor.newInstance("character1");
        Character character2 = constructor.newInstance("character2");

        int initialHealth = character2.health;
        int expectedDamage = character1 instanceof Warrior ? character1.power : character1.agility;
        int expectedHealth = initialHealth < expectedDamage ? 0 : initialHealth - expectedDamage;

        character1.attack(character2);
        assertEquals(expectedHealth, character2.health);
    }
}