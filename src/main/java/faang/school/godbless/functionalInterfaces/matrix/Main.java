package faang.school.godbless.functionalInterfaces.matrix;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<Exception> errorCatchingAction = exception -> {
            System.out.println("The matrix transformation ended with an exception: " + exception.getMessage());
        };

        TransformProcessor transformProcessor = new TransformProcessor();

        double[][] matrix = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);

        System.out.println("\nHorizontal flip:");
        var horizontalFlippedMatrix = transformProcessor.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        printMatrix(horizontalFlippedMatrix);

        System.out.println("\nVertical flip:");
        var verticalFlippedMatrix = transformProcessor.flipMatrix(matrix, FlipDirection.VERTICAL);
        printMatrix(verticalFlippedMatrix);


        //Args validating test
        System.out.println("\nTrying to flip null-valued matrix.");
        Runnable brokenAction = () -> {
            var transformedMatrix = transformProcessor.flipMatrix(null, FlipDirection.VERTICAL);
            printMatrix(verticalFlippedMatrix);
        };

        withErrorHandling(brokenAction, errorCatchingAction);

        System.out.println("\nTrying to flip matrix with null-valued direction.");
        brokenAction = () -> {
            var transformedMatrix = transformProcessor.flipMatrix(matrix, null);
            printMatrix(verticalFlippedMatrix);
        };

        withErrorHandling(brokenAction, errorCatchingAction);

        System.out.println("\nTrying to flip non-squared matrix.");

        double[][] nonSquareMatrix = new double[][]{
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        brokenAction = () -> {
            var transformedMatrix = transformProcessor.flipMatrix(nonSquareMatrix, FlipDirection.VERTICAL);
            printMatrix(verticalFlippedMatrix);
        };

        withErrorHandling(brokenAction, errorCatchingAction);

        System.out.println("\nTrying to flip empty matrix.");

        double[][] emptyMatrix = new double[0][0];

        brokenAction = () -> {
            var transformedMatrix = transformProcessor.flipMatrix(emptyMatrix, FlipDirection.VERTICAL);
            printMatrix(verticalFlippedMatrix);
        };

        withErrorHandling(brokenAction, errorCatchingAction);
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }

    public static void withErrorHandling(Runnable regularAction, Consumer<Exception> errorAction) {
        if (regularAction == null || errorAction == null) {
            throw new IllegalArgumentException("Both args must be non-valued!");
        }

        try {
            regularAction.run();
        } catch (Exception e) {
            errorAction.accept(e);
        }
    }
}
