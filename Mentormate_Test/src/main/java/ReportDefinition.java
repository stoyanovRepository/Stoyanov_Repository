public class ReportDefinition {
    private double topPerformersThreshold;
    private boolean useExprienceMultiplier;
    private double periodLimit;

    protected ReportDefinition(double topPerformersThreshold, boolean useExprienceMultiplier, double periodLimit) {
        setTopPerformersThreshold(topPerformersThreshold);
        this.useExprienceMultiplier = useExprienceMultiplier;
        setPeriodLimit(periodLimit);
    }

    public double getTopPerformersThreshold() {
        return topPerformersThreshold;
    }

    protected void setTopPerformersThreshold(double topPerformersThreshold) {
        if(topPerformersThreshold < 0){

            throw new IllegalArgumentException("TopPerformersThreshold can not be less than zero.");
        }
        this.topPerformersThreshold = topPerformersThreshold;
    }

    public boolean isUseExprienceMultiplier() {
        return useExprienceMultiplier;
    }

    public void setUseExprienceMultiplier(boolean useExprienceMultiplier) {
        this.useExprienceMultiplier = useExprienceMultiplier;
    }

    public double getPeriodLimit() {
        return periodLimit;
    }

    protected void setPeriodLimit(double periodLimit) {
        if(periodLimit < 0){
            throw new IllegalArgumentException("PeriodLimit can not be less than zero.");
        }
        this.periodLimit = periodLimit;
    }
}
