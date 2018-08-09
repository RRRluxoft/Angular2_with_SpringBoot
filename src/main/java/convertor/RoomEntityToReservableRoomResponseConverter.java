package convertor;

import home.investigation.rrr.fullstackappangularspringboot.entity.RoomEntity;
import home.investigation.rrr.fullstackappangularspringboot.model.Links;
import home.investigation.rrr.fullstackappangularspringboot.model.Self;
import home.investigation.rrr.fullstackappangularspringboot.model.response.ReservableRoomResponse;
import home.investigation.rrr.fullstackappangularspringboot.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

    @Override
    public ReservableRoomResponse convert(RoomEntity roomEntity) {

        ReservableRoomResponse reservableRoomResponse = new ReservableRoomResponse();
        reservableRoomResponse.setRoomNumber(roomEntity.getPrice());
        reservableRoomResponse.setPrice(Integer.valueOf(roomEntity.getPrice()));

        Links links = new Links();

        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + roomEntity.getId());

        links.setSelf(self);
        reservableRoomResponse.setLinks(links);

        return reservableRoomResponse;
    }

}
