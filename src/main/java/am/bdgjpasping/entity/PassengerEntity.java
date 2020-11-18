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
@Table(name = "passenger")
@Data
public class PassengerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "name")
    private String name;

    private String phone;
    //    @ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "passenger_trip",
            joinColumns = {@JoinColumn(name = "passenger_id")},
            inverseJoinColumns = {@JoinColumn(name = "trip_id")})
    Set<TripEntity> tripEntities = new HashSet<>();

    public PassengerEntity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public PassengerEntity(String name, String phone, AddressEntity addressEntity) {
        this.name = name;
        this.phone = phone;
        this.addressEntity = addressEntity;
    }

    public PassengerEntity() {
    }
}


