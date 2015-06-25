package question3;

import java.util.Scanner;

/**
 * <h1>Question 3 - Black Swan Junior Developer Test</h1>
 * <ul>
 * <li>Write a program to find the sum of each digit in the given number using recursion.</li>
 * <li>E.g.259 should return 16 because ( (2 + 5 + 9) = 16.</li>
 * </ul>
 *
 * @author Niel Koekemoer
 * @version 1.0
 * @since 2015-06-23
 */
public final class RecurringSumCalc {

    /**
     * Private constructor to ensure that the class is only static.
     */
    private RecurringSumCalc() {
        // This is an utility class and can't be instantiated by clients
        throw new AssertionError("Instantiating utility classes not allowed");
    }

    /**
     * Main Method.
     *
     * @param args arguments
     */
    public static void main(final String[] args) {
        int input;
        while (true) {
            System.out.println("Please enter a number between to find the sum of each digit for. Enter 0 to exit.");
            Scanner scc = new Scanner(System.in);
            try {
                input = Integer.parseInt(scc.nextLine().trim());
                if (input == 0) {
                    break;
                }
                System.out.println("Sum of each digit for " + input + " is:\t" + calculateSumOfDigits(input));
            } catch (NumberFormatException e) {
                System.err.println("The input entered is not an integer number");
            }
        }
    }

    /**
     * Find the sum of each digit in the given number using recursion.
     *
     * @param number number to calculate the sum from
     * @return sum of each digit
     * @see #calculateSumOfDigits(int, int)
     */
    private static int calculateSumOfDigits(final int number) {
        return calculateSumOfDigits(number, 0);
    }

    /**
     * Find the sum of each digit in the given number using recursion.
     *
     * @param number number to calculate the sum from
     * @param sum    the current sum of the recursive method
     * @return sum of each digit
     */
    private static int calculateSumOfDigits(final int number, int sum) {
        if (number == 0) {
            return sum;
        } else {
            sum += (number % 10);
            calculateSumOfDigits(number / 10, sum);
        }
        return sum;
    }

}
