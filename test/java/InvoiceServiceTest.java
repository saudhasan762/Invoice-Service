
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setUp(){
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1,1)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0,0);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserID_shouldReturn_invoiceList() {
        int userId= 2;
        InvoiceSummary summary = invoiceGenerator.invoiceList(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1,30.2,2);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}


