package SQL;

import Data.Offers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static Data.Constants.CONNECTION_STRING;

public class OfferRepository {

    public static Offers getRandomOffer() {

        String query = "SELECT TOP 1 * FROM dbo.TestOffers2 ORDER BY NEWID()";

        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {

                return new Offers(
                        rs.getString("OfferName"),
                        rs.getDouble("OfferPrice"),
                        rs.getInt("OfferDiscount")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
