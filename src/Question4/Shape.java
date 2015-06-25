package question4;

/**
 * Interface to ensure that all shape instances can calculate the area.
 *
 * @author Niel Koekemoer
 * @version 1.0
 * @since 2015-06-23
 */
public interface Shape {

    /**
     * Shape enum.
     */
    enum ShapeEnum {
        SQUARE,
        RECTANGLE,
        CIRCLE
    }

    /**
     * Calculate the area of a shape.
     *
     * @return the area of the shape
     */
    double calcArea();

    /**
     * Return the type of shape.
     *
     * @return the Enum value of the type
     */
    ShapeEnum getType();

}
