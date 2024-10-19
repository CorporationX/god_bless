package school.faang.m1s3.bjs2_36309_witcher;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Monster extends Location {
    private String name;

    public Monster(String name) {
        super();
        this.name = name;
    }

}
