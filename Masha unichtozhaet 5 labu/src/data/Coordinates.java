package data;

/**
 * Class for Flat coordinates
 */
public class Coordinates implements Comparable<Coordinates> {
    private final double x; // Значение поля должно быть больше -960, Поле не может быть null
    private final double y; // Поле не может быть null

    /**
     *
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Coordinates(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Double getY() {
        return y;
    }

    public Double getX() {
        return x;
    }

    /**
     * Compares coordinates with each other.
     * @param o - the object with which the comparison takes place
     * @return int > 0 if this > o. int = 0, if this = o. int < 0, if this < o.
     */
    @Override
    public int compareTo(Coordinates o) {
        double thisLength = Math.hypot(x, y);
        double otherLength = Math.hypot(o.x, o.y);
        return (int)(thisLength - otherLength);
    }

    @Override
    public String toString() {
        return "X = " + getX() + "; Y = " + getY();
    }

}