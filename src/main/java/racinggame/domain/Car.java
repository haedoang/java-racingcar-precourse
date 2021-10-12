package racinggame.domain;

import nextstep.utils.Randoms;

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

    private final CarName name;
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

    /** 반복해서 수행할 run 메소드 구현 */
    public void run() {
        this.setStatus(this.moveOrStop());
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

    /** 결과를 리턴한다. */
    public String print() {
        StringBuilder marker = new StringBuilder();
        for(int i = 0; i < distance; i++) {
            marker.append(DISTANCE_MARK);
        }
        return this.getName() + " : " + marker;
    }
}
