package home.investigation.rrr.fullstackappangularspringboot.rest;

import convertor.RoomEntityToReservableRoomResponseConverter;
import home.investigation.rrr.fullstackappangularspringboot.entity.ReservationEntity;
import home.investigation.rrr.fullstackappangularspringboot.entity.RoomEntity;
import home.investigation.rrr.fullstackappangularspringboot.model.request.ReservationRequest;
import home.investigation.rrr.fullstackappangularspringboot.model.response.ReservableRoomResponse;
import home.investigation.rrr.fullstackappangularspringboot.model.response.ReservationResponse;
import home.investigation.rrr.fullstackappangularspringboot.repository.PageableRoomRepository;
import home.investigation.rrr.fullstackappangularspringboot.repository.ReservationRepository;
import home.investigation.rrr.fullstackappangularspringboot.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {

    @Autowired
    PageableRoomRepository pageableRoomRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    private ConversionService conversionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservableRoomResponse> getAvailableRooms(
            @RequestParam(value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate checkin,
            @RequestParam("checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate checkout,
            Pageable pageable) {
        Page<RoomEntity> roomEntities = pageableRoomRepository.findAll(pageable);

        return roomEntities.map(new RoomEntityToReservableRoomResponseConverter()::convert);
    }

    @GetMapping(path = "/{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RoomEntity> gerRoomById(@PathVariable Long roomId) {
        RoomEntity roomEntity = roomRepository.findById(roomId).get();

        return new ResponseEntity<RoomEntity>(roomEntity, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody
                    ReservationRequest reservationRequest) {

        ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
        reservationRepository.save(reservationEntity);

        Optional<RoomEntity> roomEntity = roomRepository.findById(reservationRequest.getRoomId());

        Optional.ofNullable(roomEntity)
                .ifPresent(e -> roomEntity.get().addReservationEntity(reservationEntity));

        roomRepository.save(roomEntity.get());
        reservationEntity.setRoomEntity(roomEntity.get());

        ReservationResponse response = conversionService.convert(reservationEntity, ReservationResponse.class);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableRoomResponse> updateReservation(
            @RequestBody ReservationRequest reservationRequest) {
        return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
