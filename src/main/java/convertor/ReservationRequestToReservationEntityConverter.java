package convertor;

import home.investigation.rrr.fullstackappangularspringboot.entity.ReservationEntity;
import home.investigation.rrr.fullstackappangularspringboot.model.request.ReservationRequest;
import org.springframework.core.convert.converter.Converter;

public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity> {

    @Override
    public ReservationEntity convert(ReservationRequest reservationRequest) {
        ReservationEntity entity = new ReservationEntity();
        entity.setCheckin(reservationRequest.getCheckin());
        entity.setCheckout(reservationRequest.getCheckout());

        Long reservationRequestId = reservationRequest.getId();
        if (null != reservationRequestId) {
            entity.setId(reservationRequestId);
        }

        return entity;
    }

}
