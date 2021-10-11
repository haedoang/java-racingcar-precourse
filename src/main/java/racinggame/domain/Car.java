package racinggame.domain;

/**
 * packageName : racinggame.domain
 * fileName : Car
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class Car {
    private CarName name;
    private int distance;
    public Car(String carName) {
        this.name = new CarName(carName);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return this.distance;
    }
}
