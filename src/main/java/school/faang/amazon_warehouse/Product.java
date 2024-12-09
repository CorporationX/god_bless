package school.faang.amazon_warehouse;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

//@ToString
//@Getter
//@Setter
//@RequiredArgsConstructor
//@EqualsAndHashCode
public record Product(int id, String name, String category) {
}
