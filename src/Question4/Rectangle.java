package question4;

/**
 * Concrete Rectangle implementation.
 * @author Niel Koekemoer
 * @version 1.0
 * @since 2015-06-23
 */
public class Rectangle implements Shape {

    /**
     * Length of the rectangle.
     */
    private Double length;
    /**
     * Width of the rectangle.
     */
    private Double width;

    /**
     * Constructor.
     *
     * @param width     Width of the rectangle
     * @param length    Length of the rectangle
     */
    public Rectangle(final Double length, final Double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calcArea() {
        return width * length;
    }

    @Override
    public ShapeEnum getType() {
        return ShapeEnum.RECTANGLE;
    }
}
