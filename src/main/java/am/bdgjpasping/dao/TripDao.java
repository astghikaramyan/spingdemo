package am.bdgjpasping.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 12.11.2020.
 */
@Data
@EqualsAndHashCode
public class TripDao {
    private Long tripId;

    private Long tripNumber;

    private String timeIn;

    private String timeOut;

    private String townTo;

    private String townFrom;

    private CompanyDao company;


    private Set<PassengerDao> passengers = new HashSet<>();

    public TripDao(Long tripNumber, Long companyId, String timeIn, String timeOut, String townTo, String townFrom, CompanyDao company) {
        this.tripNumber = tripNumber;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townTo = townTo;
        this.townFrom = townFrom;
        this.company = company;
    }

    public TripDao(Long tripNumber, Long companyId, String timeIn, String timeOut, String townTo, String townFrom) {
        this.tripNumber = tripNumber;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townTo = townTo;
        this.townFrom = townFrom;
    }


    public TripDao() {
    }
}
