package am.bdgjpasping.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by User on 17.09.2020.
 */
@Entity
@Data
@Setter
@Getter
@Table(name = "companyEntity")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long comapnyId;

    @Column(name = "name")
    private String name;

    @Column(name = "found_date")
    private String foundDate;

    @OneToMany(mappedBy = "companyEntity", fetch = FetchType.LAZY)
    private Set<TripEntity> tripEntities;

    public CompanyEntity(String name, String foundDate) {
        this.name = name;
        this.foundDate = foundDate;
    }

    public CompanyEntity() {
    }
}
