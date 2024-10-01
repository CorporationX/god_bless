package ru.kraiush.spring.BJS2_27254.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "members")
@Data
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;
    private boolean gender;
    private String email;
    private String location;
    private String age;
    @NotNull
    private LocalDateTime lastDate;
    @NotNull
    private String role;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "member_id")
    private List<Phone> phones;
}
