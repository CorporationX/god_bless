package school.faang.m1s3.bjs2_36010_tomjerry;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> food = new ArrayList<>();
}
