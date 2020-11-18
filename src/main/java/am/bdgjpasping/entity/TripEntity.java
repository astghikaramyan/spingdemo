package am.bdgjpasping.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 17.09.2020.
 */
@Entity
@Table(name="trip")
@Data
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trip_id")
    private Long tripId;

    @Column(name="trip_number")
    private Long tripNumber;

    @Column(name="time_in")
    private String timeIn;

    @Column(name="time_out")
    private String timeOut;

    @Column(name="town_to")
    private String townTo;

    @Column(name="town_from")
    private String townFrom;


    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "company_id")

    @JoinColumn(name = "company_id", nullable = false, insertable = false, updatable = false)
    private CompanyEntity companyEntity;


    @ManyToMany(mappedBy = "tripEntities", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PassengerEntity> passengerEntities = new HashSet<>();

    public TripEntity(Long tripNumber, Long companyId, String timeIn, String timeOut, String townTo, String townFrom, CompanyEntity companyEntity) {
        this.tripNumber = tripNumber;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townTo = townTo;
        this.townFrom = townFrom;
        this.companyEntity = companyEntity;
    }

    public TripEntity(Long tripNumber, Long companyId, String timeIn, String timeOut, String townTo, String townFrom) {
        this.tripNumber = tripNumber;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townTo = townTo;
        this.townFrom = townFrom;
    }

    public TripEntity() {
    }
}
