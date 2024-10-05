package ru.kraiush.spring.BJS2_27254.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @NotNull
    private String name;
    private boolean gender;
    private String email;
    private String location;
    private int age;
    @NotNull
    private LocalDateTime lastDate;
    @NotNull
    private String role;

    public TeamMember(Long id, String name, boolean gender, String email, String location, int age, LocalDateTime lastDate, String role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.location = location;
        this.age = age;
        this.lastDate = lastDate;
        this.role = role;
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "member_id")
    private List<Phone> phones;

}
