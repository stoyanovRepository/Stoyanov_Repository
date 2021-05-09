public class SalesPerson {
    private String name;
    private double totalSales;
    private double salesPeriod;
    private double experienceMultiplier;

    protected SalesPerson(String name, double totalSales, double salesPeriod, double experienceMultiplier) {
        setName(name);
        setTotalSales(totalSales);
        setSalesPeriod(salesPeriod);
        setExperienceMultiplier(experienceMultiplier);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {

        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Тhe name cannot be zero or empty.");
        }
        this.name = name;
    }

    public double getTotalSales() {
        return totalSales;
    }

    protected void setTotalSales(double totalSales) {
        if(totalSales < 0){
            throw new IllegalArgumentException(this.name + " totalSales cannot be  less than zero.");
        }
        this.totalSales = totalSales;
    }

    public double getSalesPeriod() {
        return salesPeriod;
    }

    protected void setSalesPeriod(double salesPeriod) {
        if(salesPeriod < 0){
            throw new IllegalArgumentException(this.name + " salesPeriod cannot be less than zero.");
        }
        this.salesPeriod = salesPeriod;
    }

    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    private void setExperienceMultiplier(double experienceMultiplier) {
        if(experienceMultiplier < 0){
            throw new IllegalArgumentException(this.name + " experienceMultiplier cannot be less than zero.");
        }
        this.experienceMultiplier = experienceMultiplier;
    }
}
