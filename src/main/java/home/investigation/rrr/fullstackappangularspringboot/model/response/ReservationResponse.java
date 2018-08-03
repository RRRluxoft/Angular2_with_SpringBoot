package home.investigation.rrr.fullstackappangularspringboot.model.response;

import home.investigation.rrr.fullstackappangularspringboot.model.Links;

public class ReservationResponse {

    private Long id;
    private String roomNumber;
    private Integer price;
    private Links links;

    public ReservationResponse(String roomNumber, Integer price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public ReservationResponse() {
        this(null, null);
    }

    public ReservationResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
