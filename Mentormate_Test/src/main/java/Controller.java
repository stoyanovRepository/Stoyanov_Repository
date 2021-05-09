public interface Controller {
    String createSalesPerson(String name, double totalSales, double salesPeriod, double experienceMultiplier);

    String createReportDefinition(double topPerformersThreshold, boolean useExprienceMultiplier, double periodLimit);

    double calculateScore(double totalSales, double salesPeriod, double experienceMultiplier,
                          boolean useExprienceMultiplier);

    int getNumberOfSellersForResult(int size, double topPerformersThreshold);


}
