package back;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class MainBack {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        ArrayList<rootRow> rowArrayList = mapper.readValue(new URL("https://lkqd.com/sellers.json"), new ObjectMapper().getTypeFactory().constructCollectionType(ArrayList.class, rootRow.class));

        for (rootRow row : rowArrayList) {
            System.out.println(row.getVersion());
            System.out.println(row.getContact_email());
            System.out.println(row.getContact_address());
            System.out.println(row.getIdentifiers());
            System.out.println(row.getSellers());
            System.out.println("--------------------");
            System.out.println("--------------------");
        }
//        OutputResponse outputfile = new OutputResponse();
//
//        outputfile.writeResponse(rowArrayList);
    }
}