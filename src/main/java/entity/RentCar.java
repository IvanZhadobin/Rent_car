package entity;

import java.time.LocalDate;

public class RentCar {
    private final LocalDate dateStartRent;
    private final LocalDate dateFinalRent;
    private final Long clientId;
    private final Long carId;
    private final Long id;

    public RentCar(LocalDate dateStartRent, LocalDate dateFinalRent, Long clientId, Long carId, Long id) {
        this.dateStartRent = dateStartRent;
        this.dateFinalRent = dateFinalRent;
        this.clientId = clientId;
        this.carId = carId;
        this.id = id;
    }

    public LocalDate getDateStartRent() {
        return dateStartRent;
    }

    public LocalDate getDateFinalRent() {
        return dateFinalRent;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getCarId() {
        return carId;
    }

    public Long getId() { return id; }

    @Override
    public String toString() {
        return "RentCar{" + "dateStartRent=" + dateStartRent + ", dateFinalRent=" + dateFinalRent + ", clientId=" + clientId + ", carId=" + carId + '}';
    }
}
