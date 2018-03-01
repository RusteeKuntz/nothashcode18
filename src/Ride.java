/**
 * Created by Dominik on 01/03/2018.
 */
public class Ride {
    public int id;
    Point from;
    Point to;
    int start;
    int finish;

    public Ride(int id, int fromX, int fromY, int toX, int toY, int start, int finish) {
        this.id = id;
        this.from = new Point(fromX, fromY);
        this.to = new Point(toX, toY);
        this.start = start;
        this.finish = finish;
    }

    public Ride(int id, Point from, Point to, int start, int finish) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.start = start;
        this.finish = finish;
    }

    public int getId() {
        return id;
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }
}
