package faang.school.godbless.bjs2_8979;

import java.util.List;

@FunctionalInterface
public interface Calculator<T> {

  //TODO В описании задачи сказано, что будут приниматься два значения одного типа,
  //TODO нодалее везде указано, что в качестве аргумента будет передаваться список.
  T calc(List<T> numbers);

}
