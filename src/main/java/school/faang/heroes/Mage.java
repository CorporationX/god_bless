package school.faang.heroes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Mage extends Fighter {
    public Mage() {
        super(100);
    }
}
