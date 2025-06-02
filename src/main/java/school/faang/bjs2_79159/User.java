package school.faang.bjs2_79159;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private int age;
    private List<String> activities;

}
