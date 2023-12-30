package faang.school.godbless.alexbulgakoff.multithreading.parallelism.miceareverynice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class Room {
    private String name;
    private List<Food> foods;
}
