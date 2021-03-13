import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MIN_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MIN_FARE);
    }


    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare,0);
    }

    public InvoiceSummary invoiceList(int userId) {
        Map<Integer, InvoiceSummary> summaryHashMap = new HashMap<>();
        InvoiceSummary[] summary = {new InvoiceSummary(2,30.0,1),
                new InvoiceSummary(1,30.2,2),
                new InvoiceSummary(1,30.2,2)
        };
        int a = 1;
        for (InvoiceSummary invoice:summary) {
            summaryHashMap.put(a,invoice);
            a++;
        }
        Collection<InvoiceSummary> values = summaryHashMap.values();
        InvoiceSummary[] array = values.toArray(new InvoiceSummary[0]);
        return array[userId - 1];
    }
}
