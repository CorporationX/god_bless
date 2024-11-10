package ru.kraiush.spring.BJS2_27254.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TeamMemberDto {

    private long id;
    private String name;
    private boolean gender;
    private String email;
    private int age;
    private String location;
    private LocalDateTime lastDate;
    private Role role;

    private List<PhoneDto> phones;

    public List<PhoneDto> getPhones() {
        if (phones == null) {
            phones = new ArrayList<>();
        }
        return phones;
    }
}
