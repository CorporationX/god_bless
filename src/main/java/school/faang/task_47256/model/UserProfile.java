package school.faang.task_47256.model;

import school.faang.task_47256.Gender;

import java.util.List;

public record UserProfile(int userId,
                          Gender gender,
                          int age,
                          String location,
                          List<String> interests) {
}
