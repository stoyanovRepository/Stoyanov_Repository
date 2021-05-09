import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface DataProcesing {

    Map<String, Double> getAllResult();

    void parseDataReportDefinition(Path pathReportDefinitionFile) throws IOException, ParseException;

    void parseDataSalesPersons(Path pathSalesPersonsFile) throws IOException, ParseException;

    void calculateScore(Repository salesPersonRepository);

    void writingResultFile(String fileNmae) throws IOException;
}
