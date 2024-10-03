package dima.evseenko.absenteeism;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Faculty faculty;
    private int year;

    public KeyPair getKeyPair() {
        return new KeyPair(this.faculty, this.year);
    }

    @Data
    @AllArgsConstructor
    public static class KeyPair{
        private Faculty faculty;
        private int year;
    }

    enum Faculty{
        IT, MATH, PHYSICS
    }
}
