package question4;

/**
 * Concrete Square implementation.
 * @author Niel Koekemoer
 * @version 1.0
 * @since 2015-06-23
 */
public class Square extends Rectangle implements Shape {

    /**
     * This constructor hides the rectangular constructor. Thus this is not guilty of the risk of Liskov substitution principle.
     *
     * @param side Side of the square
     */
    public Square(final Double side) {
        super(side, side);
    }

    @Override
    public ShapeEnum getType() {
        return ShapeEnum.SQUARE;
    }

}
