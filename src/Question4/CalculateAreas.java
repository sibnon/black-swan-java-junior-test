package question4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>Question 4 - Black Swan Test</h1>
 * <ul>
 * <li>a Java application where a main class instantiate 3 shapes and prints the total area for each shape. Implement a calcArea() method for each</li>
 * <li>The application should clearly illustrate usage of enums, polymorphism, inheritance, overloading.</li>
 * </ul>
 *
 * @author Niel Koekemoer
 * @version 1.0
 * @since 2015-06-23
 */
public final class CalculateAreas {

    /**
     * Private constructor to ensure that the class is only static.
     */
    private CalculateAreas() {
        // This is an utility class and can't be instantiated by clients
        throw new AssertionError("Instantiating utility classes not allowed");
    }

    /**
     * Main Method.
     *
     * @param args Arguments
     */
    public static void main(final String[] args) {
        final List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.0));
        shapes.add(new Rectangle(10.0, 5.0));
        shapes.add(new Square(5.0));
        System.out.println("Calculating the areas for the following shapes " + Arrays.deepToString(Shape.ShapeEnum.values()));
        for (Shape shape : shapes) {
            System.out.println("The area for the " + shape.getType() + " is " + shape.calcArea());
        }
    }
}
