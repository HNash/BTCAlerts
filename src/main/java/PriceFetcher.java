import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class PriceFetcher
{
    static double prevPrice = 0.0d;
    static double fetchedPrice = 0.0d;
    public static void getPrice()
    {
        // Initializing URL to be accessed
        URL oracle = null;
        try
        {
            // Setting url and intializing reader
            oracle = new URL("https://blockchain.info/tobtc?currency=USD&value=1");
            BufferedReader in = null;

            try
            {
                // Initialize reader with URL
                in = new BufferedReader(new InputStreamReader(oracle.openStream()));
                // Read one line (the only line) from the page
                String inputLine = in.readLine();
                // Convert it to double, rounded to 2 d.p.
                fetchedPrice = 1 / Double.parseDouble(inputLine);
                int x = (int)(fetchedPrice * 100);
                fetchedPrice = ((double)x) / 100;
                // Close reader
                in.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        // Setting price variable to price fetched from website and updating on-screen price
        Main.price = fetchedPrice;
        Main.updatePricePanel();

        // Checking if the price has moved up past the next multiple of 1,000 or down past the previous one
        if((int)(fetchedPrice/1000) > (int)(prevPrice/1000) && prevPrice != 0.0d)
        {
            Alert.playUp();
        }
        else if ((int)(fetchedPrice/1000) < (int)(prevPrice/1000) && prevPrice != 0.0d)
        {
            Alert.playDown();
        }
        // Storing current price as previous price for next price check
        prevPrice = fetchedPrice;
    }
}
