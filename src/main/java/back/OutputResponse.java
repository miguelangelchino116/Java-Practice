package back;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class OutputResponse {

    public void writeResponse(ArrayList<Row> inputRow){
        File dest = new File(LocalDate.now() + ".csv");
        try {
            FileWriter outputfile = new FileWriter(dest);
            CSVWriter writer = new CSVWriter(outputfile);

            //Adding Headers to output file
            String[] header = {"seller_id","seller_type","name", "domain"};

            writer.writeNext(header);

            for(Row row: inputRow){
                String[] data = {
                        row.getSeller_id(),
                        row.getSeller_type(),
                        row.getName(),
                        row.getDomain(),
                };

                writer.writeNext(data);
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
