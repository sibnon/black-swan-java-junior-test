package question4;

/**
 * Concrete Circle implementation.
 *
 * @author Niel Koekemoer
 * @version 1.0
 * @since 2015-06-23
 */
public class Circle implements Shape {

    /**
     * The radius of the circle.
     */
    private Double radius;

    /**
     * Constructor.
     *
     * @param radius Radius of the circle
     */
    public Circle(final Double radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * 2;
    }

    @Override
    public ShapeEnum getType() {
        return ShapeEnum.CIRCLE;
    }

}
