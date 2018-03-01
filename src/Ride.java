/**
 * Created by Dominik on 01/03/2018.
 */
public class Ride {
    Point from;
    Point to;
    int start;
    int finish;

    public Ride(int fromX, int fromY, int toX, int toY, int start, int finish) {
        this.from = new Point(fromX, fromY);
        this.to = new Point(toX, toY);
        this.start = start;
        this.finish = finish;
    }
}
