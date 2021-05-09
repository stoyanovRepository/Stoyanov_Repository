import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.geom.IllegalPathStateException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class DataProcessingImpl implements DataProcesing{
    private JSONParser parser;
    private JSONObject jsonObject;
    private Map<String, Double> dataMap;
    private ControllerImpl controller;
    private Repository salesPersonRepository;
    private double[] count;
    private double topPerformersThreshold;
    boolean useExprienceMultiplier = false;
    double periodLimit = 0;

    protected DataProcessingImpl(ControllerImpl controller, Repository salesPersonRepository) {
        this.jsonObject = new JSONObject();
        this.parser = new JSONParser();
        this.dataMap = new TreeMap<>();
        this.controller = controller;
        this.salesPersonRepository = salesPersonRepository;
        this.topPerformersThreshold = 0;
        this.useExprienceMultiplier = false;
        this.periodLimit = 0;

    }

    @Override
    public Map<String, Double> getAllResult() {
        return this.dataMap;
    }

    @Override
    public void parseDataReportDefinition(Path pathReportDefinitionFile) throws IOException, ParseException {
        if(Files.exists(pathReportDefinitionFile)) {
            Object object = this.parser.parse(new FileReader(pathReportDefinitionFile.toString()));
            this.jsonObject = (JSONObject) object;

            if (jsonObject.get("topPerformersThreshold") instanceof Double) {
                topPerformersThreshold = (double) jsonObject.get("topPerformersThreshold");
            }
            else {
                System.out.println("TopPerformersThreshold: Invalid format.");
                System.out.println("TopPerformersThreshold  default is 0.");
            }

            if (jsonObject.get("useExprienceMultiplier") instanceof Boolean) {
                useExprienceMultiplier = (boolean) jsonObject.get("useExprienceMultiplier");
            }
            else {
                System.out.println("UseExprienceMultiplier: Invalid format.");
                System.out.println("UseExprienceMultiplier  default is false.");
            }

            if (jsonObject.get("periodLimit") instanceof Double) {
                periodLimit = (double) jsonObject.get("periodLimit");
            }
            else {
                System.out.println("PeriodLimit: Invalid format.");
                System.out.println("PeriodLimi  default is 0.");
            }

            try {
                System.out.println(this.controller.createReportDefinition(
                        this.topPerformersThreshold, this.useExprienceMultiplier, this.periodLimit));
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("ReportDefinition has invalid value.");
            }
        }
        else {
            throw new IllegalPathStateException("File does not exist");

        }

    }

    @Override
    public void parseDataSalesPersons(Path pathSalesPersonsFile) throws IOException, ParseException {
        if (Files.exists(pathSalesPersonsFile)) {
            JSONArray dataArray = (JSONArray) this.parser.parse(new FileReader(pathSalesPersonsFile.toString()));
            for (Object o : dataArray) {
                jsonObject = (JSONObject) o;
                String name = "";
                if (jsonObject.get("name") instanceof String) {
                    name = (String) jsonObject.get("name");
                }
                else {
                    System.out.println("Seller name is in an invalid format.");
                    continue;
                }

                double totalSales = 0;
                if (jsonObject.get("totalSales") instanceof Double) {
                    totalSales = (double) jsonObject.get("totalSales");
                }
                else {
                    System.out.println(name + " totalSales: Invalid format.");
                    continue;
                }

                double salesPeriod = 0;
                if (jsonObject.get("salesPeriod") instanceof Double) {
                    salesPeriod = (double) jsonObject.get("salesPeriod");
                }
                else {
                    System.out.println(name + " salesPeriod: Invalid format.");
                    continue;
                }

                double experienceMultiplier = 0;
                if (jsonObject.get("experienceMultiplier") instanceof Double) {
                    experienceMultiplier = (double) jsonObject.get("experienceMultiplier");
                }
                else {
                    System.out.println(name + " experienceMultiplier: Invalid format.");
                    continue;
                }

                try {
                    System.out.println(this.controller.createSalesPerson(name, totalSales, salesPeriod, experienceMultiplier));
                    this.salesPersonRepository.add(new SalesPerson(name, totalSales, salesPeriod, experienceMultiplier));

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        else {
            throw new IllegalPathStateException("File does not exist");
        }
    }

    @Override
    public void calculateScore(Repository salesPersonRepository){
        for(SalesPerson person: this.salesPersonRepository.getAll()){
        if (person.getSalesPeriod() <= this.periodLimit) {
            double score = this.controller.calculateScore(
                    person.getTotalSales(), person.getSalesPeriod(), person.getExperienceMultiplier()
                    , this.useExprienceMultiplier);

            dataMap.putIfAbsent(person.getName(), score);
            }
        }
    }

    @Override
    public void writingResultFile(String fileNmae) throws IOException {
        this.count = new double[]{this.controller.getNumberOfSellersForResult(this.dataMap.size(),
                this.topPerformersThreshold)};

        FileWriter writer = new FileWriter(fileNmae);
        writer.append("Name      ," );
        writer.append("Score" );
        writer.append(System.lineSeparator());
        dataMap.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue())).
                forEach(f -> {
                            if (count[0] > 0) {
                                try {
                                    writer.append(f.getKey());
                                    writer.append(", " );
                                    writer.append(String.valueOf(String.format("%.1f",f.getValue())));
                                    writer.append(System.lineSeparator());
                                    count[0]--;

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                );
        writer.flush();
        writer.close();
        System.out.println("Report file created.");
        System.out.println("File path: " + fileNmae);
    }

}
