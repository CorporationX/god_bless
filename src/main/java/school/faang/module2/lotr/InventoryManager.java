package school.faang.module2.lotr;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    private final Set<Character> characters = new HashSet<>();

    public Character createCharacter(Character characterToCreate) {
        Optional<Character> foundCharacter = findCharacter(characterToCreate);
        if (foundCharacter.isEmpty()) {
            characters.add(characterToCreate);
        }

        return characterToCreate;
    }

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        Optional<Character> foundCharacter = findCharacter(character);
        if (foundCharacter.isEmpty()) {
            throw new CharacterException();
        }

        foundCharacter.get().inventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        Optional<Character> foundCharacter = findCharacter(character);
        if (foundCharacter.isEmpty()) {
            throw new CharacterException();
        }

        foundCharacter.get().inventory().removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        Optional<Character> foundCharacter = findCharacter(character);
        if (foundCharacter.isEmpty()) {
            throw new CharacterException();
        }

        List<Item> inventory = foundCharacter.get().inventory();
        inventory.replaceAll(item -> itemPredicate.test(item) ? itemFunction.apply(item) : item);
    }


    private Optional<Character> findCharacter(Character character) {
        return characters.stream()
                .filter(c -> Objects.equals(c, character))
                .reduce((first, second) -> {
                    throw new CharacterException("Found duplicate character: %s".formatted(character));
                });
    }
}
