package school.faang.m1s3.bjs2_36309_witcher;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class City extends Location{
    private final String name;

    public City(String name) {
        super();
        this.name = name;
    }
}
