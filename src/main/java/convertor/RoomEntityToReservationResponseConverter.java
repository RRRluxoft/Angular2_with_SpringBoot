package convertor;

import home.investigation.rrr.fullstackappangularspringboot.entity.RoomEntity;
import home.investigation.rrr.fullstackappangularspringboot.model.Links;
import home.investigation.rrr.fullstackappangularspringboot.model.Self;
import home.investigation.rrr.fullstackappangularspringboot.model.response.ReservationResponse;
import home.investigation.rrr.fullstackappangularspringboot.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(RoomEntity roomEntity) {

        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setRoomNumber(roomEntity.getPrice());
        reservationResponse.setPrice(Integer.valueOf(roomEntity.getPrice()));

        Links links = new Links();

        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + roomEntity.getId());

        links.setSelf(self);
        reservationResponse.setLinks(links);

        return reservationResponse;
    }

}
