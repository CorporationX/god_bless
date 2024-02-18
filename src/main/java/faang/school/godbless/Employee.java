package src.main.java.faang.school.godbless;
public class Employee {
    private final String name;
    private final Double zp;
    private final String otdel;
    public Employee(String name, Double zp, String otdel) {
        this.name = name;
        this.zp = zp;
        this.otdel = otdel;
    }
    public String getName() {
        return name;
    }
    public Double getZp() {
        return zp;
    }
    public String getOtdel() {
        return otdel;
    }
}
