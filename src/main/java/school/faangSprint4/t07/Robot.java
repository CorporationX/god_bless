package school.faangSprint4.t07;

public record Robot(String name, int attackPower, int defensePower) {

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", attackPower=" + attackPower +
                ", defensePower=" + defensePower +
                '}';
    }
}