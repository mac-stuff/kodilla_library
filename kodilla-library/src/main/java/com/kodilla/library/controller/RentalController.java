package com.kodilla.library.controller;

import com.kodilla.library.domain.Rental;
import com.kodilla.library.domain.RentalDto;
import com.kodilla.library.exceptions.RentalNotFoundException;
import com.kodilla.library.mapper.RentalMapper;
import com.kodilla.library.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rental")
public class RentalController {

    private final DBService service;
    private final RentalMapper rentalMapper;

    @Autowired
    public RentalController(DBService service, RentalMapper rentalMapper) {
        this.service = service;
        this.rentalMapper = rentalMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRentals")
    public List<RentalDto> getRentals() {
        List<Rental> rentals = service.getAllRentals();
        return rentalMapper.mapToRentalsDtoList(rentals);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRental")
    public RentalDto getRental(@RequestParam Long rentalId) throws RentalNotFoundException {
        return rentalMapper.mapToRentalDto(
                service.getRental(rentalId).orElseThrow(RentalNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteRental")
    public void deleteRental(@RequestParam Long rentalId) {
        service.deleteRental(rentalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createRental", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRental(@RequestBody RentalDto rentalDto) {
        Rental rental = rentalMapper.mapToRental(rentalDto);
        service.saveRental(rental);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateRental")
    public RentalDto updateRental(@RequestBody RentalDto rentalDto) {
        return rentalMapper.mapToRentalDto(service.saveRental(rentalMapper.mapToRental(rentalDto)));
    }
}
