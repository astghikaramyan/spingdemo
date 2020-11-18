package am.bdgjpasping.controller;




import am.bdgjpasping.dao.CompanyDao;
import am.bdgjpasping.entity.CompanyEntity;
import am.bdgjpasping.mapper.CompanyMapper;
import am.bdgjpasping.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 18.09.2020.
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyController(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @PostMapping
    public ResponseEntity<CompanyDao> addCompany(@RequestBody CompanyDao companyDao) throws SQLException {
        CompanyEntity companyEntityEntity = this.companyMapper.toEntity(companyDao);
        companyEntityEntity = this.companyService.save(companyEntityEntity);
        return ResponseEntity.ok(this.companyMapper.toDto(companyEntityEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDao> getAddress(@PathVariable Long id) throws SQLException {
        Optional<CompanyEntity> companyEntity = this.companyService.getById(id);
        if (companyEntity.isPresent()) {
            return ResponseEntity.ok(this.companyMapper.toDto(companyEntity.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws SQLException {
        this.companyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDao> updateCompany(@RequestBody CompanyDao companyDao, @PathVariable Long id) throws SQLException {
        CompanyEntity companyEntity = this.companyMapper.toEntity(companyDao);
        companyEntity.setComapnyId(id);
        companyEntity = this.companyService.save(companyEntity);
        return ResponseEntity.ok(this.companyMapper.toDto(companyEntity));
    }
    @GetMapping
    public ResponseEntity<Set<CompanyDao>> getCompanies() throws SQLException {
        Set<CompanyEntity> companyEntitySet = this.companyService.getAll();
        if(companyEntitySet != null){
            return ResponseEntity.ok(this.companyMapper.toDtoSet(companyEntitySet));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{page}/{perPage}/{sort}")
    public ResponseEntity<Set<CompanyDao>> get(@PathVariable int page,
                                               @PathVariable int perPage, @PathVariable String sort) throws SQLException {
        Set<CompanyEntity> companyEntitySet = this.companyService.get(page, perPage, sort);
        if(companyEntitySet != null){
            return ResponseEntity.ok(this.companyMapper.toDtoSet(companyEntitySet));
        }
        return ResponseEntity.notFound().build();
    }


}
