package entity;

import java.time.LocalDate;

public class Car {
    private final Long id;
    private String mark;
    private final LocalDate yearOfRelease;
    private Integer mileage;
    private String rating;
    private Integer price;
    private final Long modelId;

    public Car(Long id, String mark, LocalDate yearOfRelease, Integer mileage, String rating, Integer price, Long modelId) {
        this.id = id;
        this.mark = mark;
        this.yearOfRelease = yearOfRelease;
        this.mileage = mileage;
        this.rating = rating;
        this.price = price;
        this.modelId = modelId;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public LocalDate getYearOfRelease() {
        return yearOfRelease;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getModelId() {
        return modelId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", mileage=" + mileage +
                ", rating='" + rating + '\'' +
                ", price=" + price +
                ", modelId=" + modelId +
                '}';
    }
}
