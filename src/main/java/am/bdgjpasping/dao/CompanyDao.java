package am.bdgjpasping.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by User on 12.11.2020.
 */
@Data
@EqualsAndHashCode
public class CompanyDao {
    private Long comapnyId;

    private String name;

    private String foundDate;

    private Set<TripDao> trips;

    public CompanyDao(String name, String foundDate) {
        this.name = name;
        this.foundDate = foundDate;
    }

    public CompanyDao() {
    }
}
