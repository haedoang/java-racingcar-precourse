package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.swing.event.CaretListener;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName : racinggame.domain
 * fileName : Car
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CarTest {

    @Test
    void T1_자동차_OK() {
        /** GIVEN */
        String name = "car1";

        /** WHEN */
        Car car = new Car(name);

        /** THEN */
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void T2_자동차_NG1() {
        /** GIVEN */
        String name2 = "";

        /** THEN */
        assertThatThrownBy(() -> new Car(name2)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름의 길이가 너무 작습니다.");
    }

    @Test
    void T3_자동차_NG2() {
        /** GIVEN */
        String name3 = "123456";

        /** THEN */
        assertThatThrownBy(() -> new Car(name3)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름의 길이가 너무 큽니다.");

    }

    @Test
    void T4_자동차_NG3() {
        /** GIVEN */
        String name4 = null;

        assertThatThrownBy(() -> new Car(name4)).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("차 이름은 null값을 가질 수 없습니다.");
    }

    @Test
    void T5_자동차_전진() {
        /** GIVEN */
        Car car = new Car("car");

        /** WHEN */
        int distance = car.getDistance();

        /** THEN */
        assertThat(distance).isEqualTo(0);

        /** WHEN */
        car.setStatus(CarStatus.MOVE);
        int afterDistance = car.getDistance();

        assertThat(afterDistance).isEqualTo(1);
        assertThat(afterDistance).isGreaterThan(distance);
    }

    @Test
    void T6_자동차_정지() {
        /** GIVEN */
        Car car = new Car("car");

        /** WHEN */
        int distance = car.getDistance();

        /** THEN */
        assertThat(distance).isEqualTo(0);

        /** WHEN */
        car.setStatus(CarStatus.STOP);
        int afterDistance = car.getDistance();

        assertThat(afterDistance).isEqualTo(0);
    }

    @Test
    void T6_전진_정지_로직_생성() {
        /** GIVEN */
        Car car = new Car("car");
        CarStatus carStatus = car.moveOrStop();

        /** THEN */
        assertThat(carStatus).isIn(CarStatus.STOP, CarStatus.MOVE);
    }

    @Test
    void T7_전진_로직_검증() {
        Car car = new Car("car1");
        int count = 10;
        int moveCnt = 0;
        int stopCnt = 0;
        for(int i = 0; i < count; i++) {
            CarStatus carStatus = car.moveOrStop();
            if(carStatus.isMove()) {
                car.setStatus(CarStatus.MOVE);
                moveCnt++;
            }
            if(carStatus.isStop()) stopCnt++;
        }

        assertThat(count).isEqualTo(moveCnt + stopCnt);
        assertThat(moveCnt).isEqualTo(car.getDistance());
    }
}