package ru.kraiush.spring.BJS2_27254.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String location;
    private int age;
    private LocalDateTime lastDate;
    private String role;

    public TeamMemberDto(long id, String name, boolean gender, String email, String location, int age, LocalDateTime lastDate, String role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.location = location;
        this.age = age;
        this.lastDate = lastDate;
        this.role = role;
    }

    private List<PhoneDTO> phones;

    public List<PhoneDTO> getPhones() {
        if(phones == null) {
            phones= new ArrayList<>();
        }
        return phones;
    }
}
