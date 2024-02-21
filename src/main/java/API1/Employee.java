package API1;

import lombok.Getter;

@Getter
public class Employee {
    private final String name;
    private final Double zp;
    private final String otdel;
    public Employee(String name, Double zp, String otdel) {
        this.name = name;
        this.zp = zp;
        this.otdel = otdel;
    }
}
