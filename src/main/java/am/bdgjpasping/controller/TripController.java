package am.bdgjpasping.controller;

import am.bdgjpasping.dao.PassengerDao;
import am.bdgjpasping.dao.TripDao;
import am.bdgjpasping.entity.PassengerEntity;
import am.bdgjpasping.entity.TripEntity;
import am.bdgjpasping.mapper.PassengerMapper;
import am.bdgjpasping.mapper.TripMapper;
import am.bdgjpasping.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 22.09.2020.
 */
@RestController
@RequestMapping("/tripEntities")
public class TripController {

    private final TripService tripService;
    private final TripMapper tripMapper;
    private final PassengerMapper passengerMapper;

    @Autowired
    public TripController(TripService tripService, TripMapper tripMapper, PassengerMapper passengerMapper){
        this.tripService = tripService;
        this.tripMapper = tripMapper;
        this.passengerMapper = passengerMapper;
    }

    @PostMapping
    public ResponseEntity<TripDao> addTrip(@RequestBody TripDao tripDao) throws SQLException {
        TripEntity tripEntityEntity = this.tripMapper.toEntity(tripDao);
        tripEntityEntity = this.tripService.save(tripEntityEntity);
        return ResponseEntity.ok(this.tripMapper.toDto(tripEntityEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDao> getTrip(@PathVariable Long id) throws SQLException {
        Optional<TripEntity> addressEntity = this.tripService.getById(id);
        if (addressEntity.isPresent()) {
            return ResponseEntity.ok(this.tripMapper.toDto(addressEntity.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws SQLException {
        this.tripService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripDao> updateCompany(@RequestBody TripDao tripDao, @PathVariable Long id) throws SQLException {
        TripEntity tripEntityEntity = this.tripMapper.toEntity(tripDao);
        tripEntityEntity.setTripId(id);
        tripEntityEntity = this.tripService.save(tripEntityEntity);
        return ResponseEntity.ok(this.tripMapper.toDto(tripEntityEntity));
    }

    @GetMapping
    public ResponseEntity<Set<TripDao>> getTrips() throws SQLException {
        Set<TripEntity> addressEntity = this.tripService.getAll();
        if(addressEntity != null){
            return ResponseEntity.ok(this.tripMapper.toDtoSet(addressEntity));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{page}/{perPage}/{sort}")
    public ResponseEntity<Set<TripDao>> get(@PathVariable int page,
                                            @PathVariable int perPage, @PathVariable String sort) throws SQLException {
        Set<TripEntity> tripEntities = this.tripService.get(page, perPage, sort);
        if(tripEntities != null){
            return ResponseEntity.ok(this.tripMapper.toDtoSet(tripEntities));
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/passengersByTripNumber/{tripNumber}")
    public ResponseEntity<Set<PassengerDao>> getPassengerByTRipNumber(@PathVariable Long tripNumber) throws SQLException {
        Set<PassengerEntity> passengerEntities = this.tripService.getPassengersOfTrip(tripNumber);
        if(passengerEntities != null){
            return ResponseEntity.ok(this.passengerMapper.toDtoSet(passengerEntities));
        }
        return ResponseEntity.notFound().build();
    }


}
//https://www.baeldung.com/spring-data-jpa-pagination-sorting