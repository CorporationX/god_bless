package ru.kraiush.spring.BJS2_27254.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    private long id;
    private String username;
    private boolean gender;
    private String email;
    private int age;
    private String location;
    private LocalDateTime lastDate;
    private Role role;

    public UserDto(String username, boolean gender, String email, int age, LocalDateTime lastDate, String location, Role role) {
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.lastDate = lastDate;
        this.location = location;
        this.role = role;
    }

    private List<PhoneDto> phones;

    public List<PhoneDto> getPhones() {
        if (phones == null) {
            phones = new ArrayList<>();
        }
        return phones;
    }
}
