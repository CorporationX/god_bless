package faang.school.godbless.Calculator;

@FunctionalInterface
interface Calculator <T>{
    T calculate(T a, T b);
}