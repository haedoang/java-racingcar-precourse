package racinggame.domain;

/**
 * packageName : racinggame.domain
 * fileName : Car
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class Car {
    private final int CAR_MOVE_STEP = 1;

    private CarName name;
    private int distance;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public CarName getName() {
        return name;
    }

    public void move() {
        this.distance = this.distance + CAR_MOVE_STEP;
    }

    public void run(CarStatus status) {
        if(status.isMove()) this.move();
    }

    public int getDistance() {
        return distance;
    }
}
