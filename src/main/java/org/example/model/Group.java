package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Group {
    private String faculty;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return getYear() == group.getYear() && Objects.equals(getFaculty(), group.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFaculty(), getYear());
    }
}
