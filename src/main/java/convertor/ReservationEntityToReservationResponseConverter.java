package convertor;

import home.investigation.rrr.fullstackappangularspringboot.entity.ReservationEntity;
import home.investigation.rrr.fullstackappangularspringboot.model.response.ReservationResponse;
import org.springframework.core.convert.converter.Converter;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(ReservationEntity reservationEntity) {
        ReservationResponse response = new ReservationResponse();
        response.setCheckin(reservationEntity.getCheckin());
        response.setCheckout(reservationEntity.getCheckout());

        Long reservationEntityId = reservationEntity.getId();
        if (null != reservationEntityId) {
            response.setId(reservationEntityId);
        }

        return response;
    }
}
