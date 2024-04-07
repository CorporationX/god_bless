package GameOfThrons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;
}
