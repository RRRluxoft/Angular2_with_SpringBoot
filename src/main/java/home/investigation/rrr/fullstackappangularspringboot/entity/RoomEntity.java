package home.investigation.rrr.fullstackappangularspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer roomNumber;

    @NotNull
    private String price;

    public RoomEntity(@NotNull Integer roomNumber, @NotNull String price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public RoomEntity() {
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public @NotNull String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
