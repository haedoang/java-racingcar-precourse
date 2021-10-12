package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.common.Constants;

import static racinggame.common.Constants.*;

/**
 * packageName : racinggame.domain
 * fileName : Car
 * author : haedoang
 * date : 2021-10-12
 * description :
 */
public class Car {
    private static final int MOVE_STEP = 1;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MAX_STOP_NUMBER = 3;

    private CarName name;
    private int distance;

    public Car(String carName) {
        this.name = new CarName(carName);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance;
    }

    /** Move Status 일 때만 전진한다. */
    public void setStatus(CarStatus status) {
        if(status.isMove()) distance = distance + MOVE_STEP;
    }

    /** 전진/정지 랜덤 로직 메서드 구현. */
    public CarStatus moveOrStop() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return randomNumber > MAX_STOP_NUMBER ? CarStatus.MOVE : CarStatus.STOP;
    }

    public String print() {
        String marker =  "";
        for(int i = 0; i < distance; i++) {
            marker += DISTANCE_MARK;
        }
        return this.getName() + " : " + marker;
    }
}
