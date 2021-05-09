import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
   private Repository salesPersonRepository;

   protected ControllerImpl(Repository salesPersonRepository) {

       this.salesPersonRepository = salesPersonRepository;
   }

   @Override
   public String createSalesPerson(String name, double totalSales, double salesPeriod, double experienceMultiplier){
      SalesPerson salesPerson = this.salesPersonRepository.getByName(name);
      if(salesPerson != null){
         throw new IllegalArgumentException(String.format ("SalesPerson %s is already created.",name));
      }
      salesPerson = new SalesPerson(name, totalSales, salesPeriod, experienceMultiplier);
      this.salesPersonRepository.add(salesPerson);
      return String.format ("SalesPerson %s is created.",name);
   }

   @Override
   public String createReportDefinition(double topPerformersThreshold, boolean useExprienceMultiplier, double periodLimit){
      ReportDefinition reportDefinition = new ReportDefinition(topPerformersThreshold, useExprienceMultiplier, periodLimit);
      return "ReportDefinition is created.";
   }

   @Override
   public double calculateScore(double totalSales, double salesPeriod, double experienceMultiplier,
                                boolean useExprienceMultiplier){
      double score = 0;
      if(useExprienceMultiplier) {
         if(salesPeriod > 0){
            score = (totalSales / salesPeriod) * experienceMultiplier;
         }
      }else {
         if(salesPeriod > 0){
            score = totalSales / salesPeriod;
         }
      }
      return score;
   }

   @Override
   public int getNumberOfSellersForResult(int size, double topPerformersThreshold){
      double count = Math.floor((size * topPerformersThreshold) / 100);
      return (int) count;
   }

}
