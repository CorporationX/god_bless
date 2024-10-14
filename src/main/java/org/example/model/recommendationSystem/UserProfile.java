package org.example.model.recommendationSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    private long userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;
}
