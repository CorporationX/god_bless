package faang.school.godbless.lru;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Data {
    private int ID;
    private int values;
    @Setter
    private Long timestamp;

    public Data(int ID, int values) {
        this.ID = ID;
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return ID == data.ID && values == data.values;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, values);
    }

    @Override
    public String toString() {
        return "Data{" +
                "values=" + values +
                ", ID=" + ID +
                '}';
    }
}
