package faang.school.godbless;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestMap {

    @Test
    public void testAddHouse(){
        HashMap<String, House> houses=new HashMap<>();
        House stark=new House("Starks", "Wolf");

        assertEquals(stark, houses.get("Startks"));
    }

    private void testRemoveHouse(){
        HashMap<String, House> houses=new HashMap<>();
        houses.put("Starks", new House("Starks", "Wolf"));
        houses.put("Lanister", new House("Lanister", "Lion"));

        House stark=houses.get("Starks");
        House lanister=houses.get("Lanister");
        assertNotNull(stark);
        assertNotNull(lanister);

        assertEquals("Stark", stark.getName());
        assertEquals("Lanister", lanister.getName());
    }
    private void testFindHouse(){
        HashMap<String, House> houses=new HashMap<>();
        houses.put("Starks", new House("Starks", "Wolf"));
        houses.put("Barateon", new House("Barateon", "Three-headed Dragon"));

        House barateon=houses.get("Barateon");
        assertNotNull(barateon);

        assertEquals("Barateon", barateon.getName());
        assertEquals("Three-headed Dragon", barateon.getSigil());

    }


}
