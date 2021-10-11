package racinggame.domain;

import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;
import nextstep.utils.Randoms;
import racinggame.common.Constants;

/**
 * packageName : racinggame.domain
 * fileName : Car
 * author : haedoang
 * date : 2021/10/11
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

    public CarStatus moveOrStop() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return randomNumber > MAX_STOP_NUMBER ? CarStatus.MOVE : CarStatus.STOP;
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return this.distance;
    }

    public void setStatus(CarStatus status) {
        if(status.isMove()) this.distance = this.distance + MOVE_STEP;
    }

    public void run() {
        this.setStatus(this.moveOrStop());
    }

    public void print() {
        String marker = "";
        for(int i = 0; i < this.distance; i++) {
            marker += Constants.DISTANCE_MARK;
        }
        System.out.println(this.getName() + " : " + marker);
    }

}
