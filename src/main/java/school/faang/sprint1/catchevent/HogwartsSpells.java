package school.faang.sprint1.catchevent;

import java.util.List;

/**
 * Hogwarts spell management system.
 */
public interface HogwartsSpells {

    /**
     * Adds a new spell event to the system. Generates unique ID.
     *
     * @param eventType         type of spell(e.g., "Charm", "Transfiguration", "Defense")
     * @param actionDescription description of the spell's action
     * @return the created SpellEvent object with unique ID generated
     */
    SpellEvent addSpellEvent(String eventType, String actionDescription);

    /**
     * Retrieves a spell event by its unique ID.
     *
     * @param id unique spell event ID to search by
     * @throws java.util.NoSuchElementException if no spell found with the given ID
     */
    SpellEvent getSpellEventById(int id);

    /**
     * Retrieves all spell events of a specific type.
     *
     * @param eventType the type of spell event to retrieve
     * @return list of spell events for given type, or empty list if non found
     */
    List<SpellEvent> getSpellEventsByType(String eventType);

    /**
     * Removes a spell event by its ID from the system.
     *
     * @param id unique ID of the spell to remove
     * @return true what event was removed successfully, and false when no such event was found in the
     * system
     */
    boolean deleteSpellEvent(int id);

    /**
     * Prints All spell events currently stored in the system into the console.
     * <p> Print the ID, type, and data of every spell event.
     */
    void printAllSpellEvents();

}
