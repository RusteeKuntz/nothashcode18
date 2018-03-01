import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) throws IOException {

        int rows, columns, noVehicles, noRides, bonus, steps;
        int[] aux;
        List<Ride> rides = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("a_example.in"));
            String line = br.readLine();
            List<Point> positions;
            String[] strs = line.trim().split("\\s+");
            aux = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                aux[i]  = Integer.parseInt(strs[i]);
            }
            rows = aux[0];
            columns = aux[1];
            noVehicles = aux[2];
            noRides = aux[3];
            bonus = aux[4];
            steps = aux[5];

            for (int i = 0; i < noRides; ++i) {
                line = br.readLine();
                strs = line.trim().split("\\s+");
                Ride ride = new Ride(i, new Point(Integer.parseInt(strs[1]),
                                        Integer.parseInt(strs[0])),
                                        new Point(Integer.parseInt(strs[3]),
                                                Integer.parseInt(strs[2])),
                        Integer.parseInt(strs[4]), Integer.parseInt(strs[5]));
                rides.add(ride);
            }

            System.out.printf("%d\n", rows);
            System.out.printf("%d\n", columns);
            System.out.printf("%d\n", noVehicles);
            System.out.printf("%d\n", noRides);
            System.out.printf("%d\n", bonus);
            System.out.printf("%d\n", steps);

            for (int i = 0; i < rides.size(); ++i) {
                System.out.printf("\n%d\n", i);
                System.out.printf(rides.get(i).from.toString());
                System.out.printf(rides.get(i).to.toString());
                System.out.printf("%d\n", rides.get(i).start);
                System.out.printf("%d\n", rides.get(i).finish);
            }

        positions = new ArrayList<>();
        for (int i = 0; i < noVehicles; ++i) {
            positions.add(new Point(0, 0));
        }

        List<Integer> occupied = new ArrayList<>();
        for (int i = 0; i < noVehicles; ++i) {
            occupied.add(-1);
        }

        List<List<Integer>> vehRides = new ArrayList<>();
            for (int i = 0; i < noVehicles; ++i) {
                vehRides.add(new ArrayList<Integer>());
            }

        for(int i = 0; i < steps; ++i) {
            rides = clearedRides(i, rides, positions, noVehicles, steps);
            for (int j = 0; j < rides.size(); ++j) {
                int closest = getClosest(rides.get(j).getFrom(), positions).getKey();
                if (occupied.get(closest) != -1) {
                    occupied.set(closest, positions.get(closest).getDistance(rides.get(j).getFrom())
                            + rides.get(j).getFrom().getDistance(rides.get(j).getTo()));
                    vehRides.get(closest).add(j);
                    rides.remove(j);
                }

            }
        }

        for (int i = 0; i < noVehicles; ++i) {
            System.out.printf("%d", vehRides.get(i).size());
            for (Integer r : vehRides.get(i)) {
                System.out.printf(" %d", r);
            }
            System.out.println();
        }

        } finally {}
    }


    public static Pair<Integer, Integer> getClosest(Point a, List<Point> pos) {
        int max = -1;
        int maxDist = Integer.MAX_VALUE;
        for (int i = 0; i < pos.size(); ++i) {
            if (a.getDistance(pos.get(i)) < maxDist) {
                maxDist = a.getDistance(pos.get(i));
                max = i;
            }
        }
        return new Pair<>(max, maxDist);
    }


    public static List<Ride> clearedRides(int step, List<Ride> rides, List<Point> pos, int veh, int last) {
        List<Ride> ret = new ArrayList<>();
        for (Ride r : rides) {
                for (int i = 0; i < veh; ++i) {
                    int aux = r.getFrom().getDistance(pos.get(getClosest(r.getFrom(), pos).getKey()))
                            + r.getFrom().getDistance(r.getTo()) + step;
                    if (aux <= r.getFinish() || aux <= last) {
                        ret.add(r);
                        break;
                    }
                }
            }
        return ret;
        }

        public static Point move(Point start, Point goal) {
            if(start.getX() < goal.getX()) {
                return new Point(start.getX() + 1, start.getY());
            } else if (start.getX() > goal.getX()) {
                return new Point(start.getX() - 1, start.getY());
            } else if (start.getY() < goal.getY()){
                return new Point(start.getX(), start.getY() + 1);
            } else if (start.getY() > goal.getY()) {
                return new Point(start.getX(), start.getY() - 1);
            }
            return start;
        }
}
