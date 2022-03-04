package Les5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static final String pathToFile1 = "src/files/1.csv";
    public static final String pathToFile2 = "src/files/2.csv";
    public static final String title = "value1"+ ";" + "value2"
            + ";" + "value3 \n";
    public static final String [] [] data1= {{"100",";","200",";","123"},{"300",";","400",";","500"}};

    public static void main(String[] args) throws IOException {
        writer();
        reader();
    }

    public static void writer() throws IOException {
        try (FileWriter writer = new FileWriter(pathToFile1);) {
            writer.write(title);
            for (int i = 0; i<2; i++){
                for (int j = 0; j<5; j++){
                    writer.write(data1[i][j]);
                }
                writer.write("\n");

            }
        }
    }
    public static AppData reader() throws IOException {
        AppData appData = new AppData();

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader (new FileReader(pathToFile1))) {
            String line = bufferedReader.readLine();
                appData.setHeader( line.split(";"));
            System.out.println(line);
                while ((line = bufferedReader.readLine()) != null) {
                    String[] values = line.split(";");
                    records.add(Arrays.asList(values));
                    System.out.println(line);
                }

        }catch (IOException e){
                e.printStackTrace();

        int[][] resultData = new int[records.size()][3];

        for(int i=0;i<records.size();i++){
            for(int j=0;j<records.get(i).size();j++){
                resultData[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }
        appData.setData(resultData);
    }
        return appData;
    }
static class AppData {
            static String[] header;
            static int[][] data;

            public void setHeader(String[] header) {
                this.header = header;
            }

            public void setData(int[][] data) {
                this.data = data;
            }
    }
}
