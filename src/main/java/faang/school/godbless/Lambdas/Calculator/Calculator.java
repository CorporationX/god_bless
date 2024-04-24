package faang.school.godbless.Lambdas.Calculator;

@FunctionalInterface
interface Calculator <T>{
    T calculate(T a, T b);
}