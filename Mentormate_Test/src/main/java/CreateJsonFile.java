import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class CreateJsonFile {
    public static void main(String args[]) throws IOException {
        JSONObject salesPersonDetails1 = new JSONObject();
        JSONArray allData = new JSONArray();
        salesPersonDetails1.put("name", "John Smith");
        salesPersonDetails1.put("totalSales",250.0 );
        salesPersonDetails1.put("salesPeriod", 10.0);
        salesPersonDetails1.put("experienceMultiplier", 0.5);

        allData.add(salesPersonDetails1);

        JSONObject sales_PersonDetails2 = new JSONObject();

        sales_PersonDetails2.put("name", "David Prowless");
        sales_PersonDetails2.put("totalSales", 250.0);
        sales_PersonDetails2.put("salesPeriod", 10.0);
        sales_PersonDetails2.put("experienceMultiplier", 0.5);

        allData.add(sales_PersonDetails2);

        JSONObject details = new JSONObject();
        details.put("topPerformersThreshold", 10.0);
        details.put("useExprienceMultiplier", false);
        details.put("periodLimit", 10.0);



        FileWriter file = new FileWriter("D:/Data.json");
        file.write(allData.toJSONString());
        file.close();

        file = new FileWriter("D:/ReportDefinition.json");
        file.write(details.toJSONString());
        file.close();

    }

}
