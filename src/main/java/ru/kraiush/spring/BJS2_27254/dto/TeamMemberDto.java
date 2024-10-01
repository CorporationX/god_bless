package ru.kraiush.spring.BJS2_27254.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class TeamMemberDto {

    private long id;
    private String name;
    private boolean gender;
    private String email;
    private String location;
    private String age;
    private LocalDateTime startDate;

    private List<PhoneDTO> phones;

    public List<PhoneDTO> getPhones() {
        if (phones == null) {
            phones = new ArrayList<>();
        }
        return phones;
    }
}
