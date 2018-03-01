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
        //List<Ride> rides = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("a_example.in"));
            String line = br.readLine();

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

            /*for (int i = 0; i < noRides; ++i) {
                line = br.readLine();
                strs = line.trim().split("\\s+");
                Ride ride = new Ride(new Point(Integer.parseInt(strs[1]),
                                        Integer.parseInt(strs[0])),
                                        new Point(Integer.parseInt(strs[3]),
                                                Integer.parseInt(strs[2])),
                        Integer.parseInt(strs[4]), Integer.parseInt(strs[5]))0
                rides.add(ride);
            }*/

            System.out.printf("%d\n", rows);
            System.out.printf("%d\n", columns);
            System.out.printf("%d\n", noVehicles);
            System.out.printf("%d\n", noRides);
            System.out.printf("%d\n", bonus);
            System.out.printf("%d\n", steps);


        } finally {}
    }
}
