package am.bdgjpasping.controller;



import am.bdgjpasping.dao.PassengerDao;
import am.bdgjpasping.entity.PassengerEntity;
import am.bdgjpasping.mapper.PassengerMapper;
import am.bdgjpasping.service.PassengerService;
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
@RequestMapping("/passengerEntities")
public class PassengerController {
    private final PassengerService passengerService;
    private final PassengerMapper passengerMapper;

    @Autowired
    public PassengerController(PassengerService passengerService,PassengerMapper passengerMapper) {
        this.passengerService = passengerService;
        this.passengerMapper = passengerMapper;
    }
    @PostMapping
    public ResponseEntity<PassengerDao> addCompany(@RequestBody PassengerDao passengerDao) throws SQLException {
        PassengerEntity passengerEntity = this.passengerMapper.toEntity(passengerDao);
        passengerEntity = this.passengerService.save(passengerEntity);
        return ResponseEntity.ok(this.passengerMapper.toDto(passengerEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDao> getAddress(@PathVariable Long id) throws SQLException {
        Optional<PassengerEntity> passengerEntity = this.passengerService.getById(id);
        if (passengerEntity.isPresent()) {
            return ResponseEntity.ok(this.passengerMapper.toDto(passengerEntity.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws SQLException {
        this.passengerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerDao> updateCompany(@RequestBody PassengerDao passengerDao, @PathVariable Long id) throws SQLException {
        PassengerEntity passengerEntity = this.passengerMapper.toEntity(passengerDao);
        passengerEntity.setPassengerId(id);
        passengerEntity = this.passengerService.save(passengerEntity);
        return ResponseEntity.ok(this.passengerMapper.toDto(passengerEntity));
    }
    @GetMapping
    public ResponseEntity<Set<PassengerDao>> getPassengers() throws SQLException {
        Set<PassengerEntity> companySet = this.passengerService.getAll();
        if(companySet != null){
            return ResponseEntity.ok(this.passengerMapper.toDtoSet(companySet));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{page}/{perPage}/{sort}")
    public ResponseEntity<Set<PassengerDao>> get(@PathVariable int page,
                                                 @PathVariable int perPage, @PathVariable String sort) throws SQLException {
        Set<PassengerEntity> passengerEntities = this.passengerService.get(page, perPage, sort);
        if(passengerEntities != null){
            return ResponseEntity.ok(this.passengerMapper.toDtoSet(passengerEntities));
        }
        return ResponseEntity.notFound().build();
    }
}

