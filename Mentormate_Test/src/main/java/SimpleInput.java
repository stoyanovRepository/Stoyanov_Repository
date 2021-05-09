import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleInput {
    public static void main(String args[]) throws IOException {
        JSONArray allData = new JSONArray();

        JSONObject salesPersonDetails = new JSONObject();
        salesPersonDetails.put("name", "John Smith");
        salesPersonDetails.put("totalSales", 10.0 );
        salesPersonDetails.put("salesPeriod", 5.0);
        salesPersonDetails.put("experienceMultiplier", 10.0);

        allData.add(salesPersonDetails);

        JSONObject salesPersonDetailsOne = new JSONObject();
        salesPersonDetailsOne.put("name", "John Smith");
        salesPersonDetailsOne.put("totalSales", 10000.0 );
        salesPersonDetailsOne.put("salesPeriod", 10.0);
        salesPersonDetailsOne.put("experienceMultiplier", 2.0);

        allData.add(salesPersonDetailsOne);

        JSONObject salesPersonDetailsTwo = new JSONObject();

        salesPersonDetailsTwo.put("name", "Rayn Col");
        salesPersonDetailsTwo.put("totalSales", -250.0);
        salesPersonDetailsTwo.put("salesPeriod", 10.0);
        salesPersonDetailsTwo.put("experienceMultiplier", 0.5);

        allData.add(salesPersonDetailsTwo);

        JSONObject salesPersonDetailsThree = new JSONObject();

        salesPersonDetailsThree.put("name", "Math Ben");
        salesPersonDetailsThree.put("totalSales", 2500.0);
        salesPersonDetailsThree.put("salesPeriod", 10.0);
        salesPersonDetailsThree.put("experienceMultiplier", 0.5);

        allData.add(salesPersonDetailsThree);

        JSONObject salesPersonDetailsFour = new JSONObject();

        salesPersonDetailsFour.put("name", "Peter Smith");
        salesPersonDetailsFour.put("totalSales", 500.0);
        salesPersonDetailsFour.put("salesPeriod", 20.0);
        salesPersonDetailsFour.put("experienceMultiplier", 1.1);

        allData.add(salesPersonDetailsFour);

        JSONObject salesPersonDetailsFive = new JSONObject();

        salesPersonDetailsFive.put("name", "Samanta Hpur");
        salesPersonDetailsFive.put("totalSales", 9.0);
        salesPersonDetailsFive.put("salesPeriod", 7.0);
        salesPersonDetailsFive.put("experienceMultiplier", 5.0);

        allData.add(salesPersonDetailsFive);

        JSONObject salesPersonDetailsSix = new JSONObject();

        salesPersonDetailsSix.put("name", "Krina Johnson");
        salesPersonDetailsSix.put("totalSales", 3500.0);
        salesPersonDetailsSix.put("salesPeriod", 8.0);
        salesPersonDetailsSix.put("experienceMultiplier", 0.2);

        allData.add(salesPersonDetailsSix);

        JSONObject salesPersonDetailsSeven = new JSONObject();

        salesPersonDetailsSeven.put("name", "Doni Jouns");
        salesPersonDetailsSeven.put("totalSales", 9000.0);
        salesPersonDetailsSeven.put("salesPeriod", 7.0);
        salesPersonDetailsSeven.put("experienceMultiplier", 0.9);

        allData.add(salesPersonDetailsSeven);

        JSONObject salesPersonDetailsEight = new JSONObject();

        salesPersonDetailsEight.put("name", "Burma Mendl");
        salesPersonDetailsEight.put("totalSales", 500.0);
        salesPersonDetailsEight.put("salesPeriod", 5.0);
        salesPersonDetailsEight.put("experienceMultiplier", 0.5);

        allData.add(salesPersonDetailsEight);

        JSONObject salesPersonDetailsNine = new JSONObject();

        salesPersonDetailsNine.put("name", "Shon Pen");
        salesPersonDetailsNine.put("totalSales", 9528.0);
        salesPersonDetailsNine.put("salesPeriod", 10.0);
        salesPersonDetailsNine.put("experienceMultiplier", 0.5);

        allData.add(salesPersonDetailsNine);

        JSONObject salesPersonDetailsTen = new JSONObject();

        salesPersonDetailsTen.put("name", "Hilary Ouen");
        salesPersonDetailsTen.put("totalSales", 22500.0);
        salesPersonDetailsTen.put("salesPeriod", 6.0);
        salesPersonDetailsTen.put("experienceMultiplier", 0.6);

        allData.add(salesPersonDetailsTen);

        JSONObject salesPersonDetailsEleven = new JSONObject();

        salesPersonDetailsEleven.put("name", "Mary Poppins");
        salesPersonDetailsEleven.put("totalSales", 18500.0);
        salesPersonDetailsEleven.put("salesPeriod", 4.0);
        salesPersonDetailsEleven.put("experienceMultiplier", 0.6);

        allData.add(salesPersonDetailsEleven);

        JSONObject details = new JSONObject();
        details.put("topPerformersThreshold", 50.0);
        details.put("useExprienceMultiplier", true);
        details.put("periodLimit", 10.0);



        FileWriter file = new FileWriter("D:/DataSimple.json");
        file.write(allData.toJSONString());
        file.close();

        file = new FileWriter("D:/ReportDefinitionSimple.json");
        file.write(details.toJSONString());
        file.close();

    }
}
