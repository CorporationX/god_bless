package faang.school.godbless.marvel;

public class Pair <T1, T2> {
  private T1 first;
  private T2 second;

  public Pair(T1 firstHero, T2 secondHero) {
    this.first = firstHero;
    this.second = secondHero;
  }

  public T1 getFirst() {
    return first;
  }

  public T2 getSecond() {
    return second;
  }
}
