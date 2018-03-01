import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {

        int rows, columns, vehicles, rides, bonus, steps;
        int[] aux;

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.in"));
            String line = br.readLine();

            String[] strs = line.trim().split("\\s+");
            aux = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                aux[i]  = Integer.parseInt(strs[i]);
            }
            rows = aux[0];
            columns = aux[1];
            vehicles = aux[2];
            rides = aux[3];
            bonus = aux[4];
            steps = aux[5];


            /*while (fileRead != null) {

            }*/



        } finally {}
    }
}
