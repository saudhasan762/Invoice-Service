public class InvoiceSummary {
    private final int numORides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numOfRides, double totalFare,int id) {
        this.numORides = numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numORides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numORides == that.numORides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }

}
