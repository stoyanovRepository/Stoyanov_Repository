import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        Path pathSalesPersonsFile = Paths.get("D:/DataSimple.json");
        Path pathReportDefinitionFile = Paths.get("D:/ReportDefinitionSimple.json");

        Repository repository = new SalesPersonRepository();
        ControllerImpl controller = new ControllerImpl(repository);
        DataProcessingImpl dataProcessing = new DataProcessingImpl(controller, repository);

        dataProcessing.parseDataSalesPersons(pathSalesPersonsFile);
        dataProcessing.parseDataReportDefinition(pathReportDefinitionFile);
        dataProcessing.calculateScore(repository);
        dataProcessing.writingResultFile("D:/Result.csv");
    }
}

