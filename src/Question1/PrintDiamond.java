package question1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Question 1 - Black Swan Test</h1>
 * <ul>
 * <li>Write a Java application that accepts an odd number from 3 - 9 (inclusive).</li>
 * <li>If input is invalid, print error to user (with meaningful reason) of why input is invalid (not generic).</li>
 * <li>If valid, print out a diamond shape as per the document.</li>
 * </ul>
 *
 * @author Niel Koekemoer
 * @version 1.0
 * @since 2015-06-23
 */
public final class PrintDiamond {

    /**
     * Maximum allowed height of the diamond.
     */
    private static final int MIN_HEIGHT = 3;
    /**
     * Minimum allowed height of the diamond.
     */
    private static final int MAX_HEIGHT = 9;

    /**
     * Private constructor.
     */
    private PrintDiamond() {
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
            System.out.println("Please enter an odd number between 3 and 9. Enter 0 to exit.");
            Scanner scc = new Scanner(System.in);
            try {
                input = Integer.parseInt(scc.nextLine().trim());
                if (input == 0) {
                    break;
                }
                draw(input);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Method to draw the diamond.
     *
     * @param height the height of the diamond
     *
     */
    private static void draw(final int height) {
        // Validate the height
        if (height % 2 == 0 || height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new RuntimeException("The number " + height + " entered is not an odd integer value between 3 - 9");
        }
        final String maxStars = fillString(height, '*');
        final String maxSpaces = fillString(height, ' ');
        for (int i = 0; i < height; i++) {
            String line = maxSpaces.substring(0, numberOfSpacesForLine(height, i)) + maxStars.substring(0, numberOfStarsForLine(height, i));
            // Substitute the center of the diamond with the height received
            final int middleIndex = height / 2;
            if (i == middleIndex) {
                line = maxStars.substring(0, middleIndex).concat(String.valueOf(height)).concat(maxStars.substring(0, middleIndex));
            }
            System.out.println(line);
        }
    }

    /**
     * Helper method to fill a string with characters.
     *
     * @param width the width of the string
     * @param val   the character to fill the string with
     * @return a string filled with characters
     */
    private static String fillString(final int width, final char val) {
        final char[] characters = new char[width];
        Arrays.fill(characters, val);
        return new String(characters);
    }

    /**
     * Calculate the number of starts for a line.
     *
     * @param   diamondHeight   the total height of the diamond
     * @param   line            the line to calculate the number of stars
     * @return  the number of stars in the line
     */
    private static int numberOfStarsForLine(final int diamondHeight, final int line) {
        return -Math.abs(line - (diamondHeight - 1) / 2) * 2 + diamondHeight;
    }

    /**
     * Calculate the number of spaces before the stars for a line.
     *
     * @param diamondHeight the height of the diamond
     * @param line          the line to calculate the spaces for
     * @return the amount of spaces before the starts
     */
    private static int numberOfSpacesForLine(final int diamondHeight, final int line) {
        return Math.abs(line - (diamondHeight + 1) / 2 + 1);
    }
}
