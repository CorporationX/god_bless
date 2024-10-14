package school.faang.gameofthrones;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class House {
    private String name;   // Name of the house
    private String sigil;  // Sigil of the house
}