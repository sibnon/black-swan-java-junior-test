package question2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <h1>Question 2 - Black Swan Test</h1>
 * <ul>
 * <li>Write a program to find duplicate characters in a string, sorted from least to most duplicates.</li>
 * </ul>
 *
 * @author Niel Koekemoer
 * @version 1.0
 * @since 2015-06-23
 */
public final class Duplicates {

    /**
     * Private constructor to ensure that the class is only static.
     */
    private Duplicates() {
        // This is an utility class and can't be instantiated by clients
        throw new AssertionError("Instantiating utility classes not allowed");
    }

    /**
     * Main method.
     *
     * @param args Arguments
     */
    public static void main(String[] args) {
        String input;
        while (true) {
            System.out.println("Please enter an string to search for duplicates. Enter \"Exit\" or \"Quit\" to exit.");
            Scanner scc = new Scanner(System.in);
            try {
                input = scc.nextLine().trim();
                if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                    break;
                }
                findDuplicates(input);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Method to find duplicates in a string. The default implementation will ignore the case and the whitespaces.
     *
     * @param str The String to parse for any duplicate characters
     */
    private static void findDuplicates(String str) {
        final boolean ignoreCases = true;
        final boolean ignoreWhitespaces = true;

        // If whitespaces must be ignore, remove all the whitespaces in the string
        if (ignoreWhitespaces) {
            str = str.replaceAll("\\s", "");
        }

        final SortedMap<Character, Integer> duplicationCount = new TreeMap<>();
        for (char charAt : str.toCharArray()) {
            if (ignoreCases) {
                charAt = Character.toLowerCase(charAt);
            }
            duplicationCount.put(charAt, !duplicationCount.containsKey(charAt) ? 1 : duplicationCount.get(charAt) + 1);
        }

        boolean hasDuplicates = false;

        // Sort Map
        final SortedSet<Map.Entry<Character, Integer>> sortedSet = new TreeSet<>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> e1,
                                       Map.Entry<Character, Integer> e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                });

        sortedSet.addAll(duplicationCount.entrySet());
        final Iterator<Map.Entry<Character, Integer>> it = sortedSet.iterator();
        while (it.hasNext()) {
            final Map.Entry<Character, Integer> entry = it.next();
            if (entry.getValue() > 1) {
                hasDuplicates = true;
                System.out.println(entry.getKey() + "->" + entry.getValue());
            }
        }
        if (!hasDuplicates) {
            System.out.println("There was no duplicates in the string");
        }
    }

}
