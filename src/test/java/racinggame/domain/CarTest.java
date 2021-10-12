package racinggame.domain;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import racinggame.common.Constants;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName : racinggame.domain
 * fileName : CarTest
 * author : haedoang
 * date : 2021-10-12
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
        /** THEN */
        assertThatThrownBy(() -> new Car(name4)).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("차 이름은 null값을 가질 수 없습니다.");
    }

    @Test
    void T5_랜덤하게_자동차를_전진_또는_정지한다() {
        /** GIVEN */
        Car car = new Car("car");

        /** WHEN */
        CarStatus carStatus = car.moveOrStop();

        /** THEN */
        assertThat(carStatus).isIn(CarStatus.MOVE, CarStatus.STOP);
    }

    @Test
    void T6_자동차_전진() {
        /** GIVEN */
        Car car = new Car("car");
        /** WHEN */
        int distance = car.getDistance();
        /** THEN */
        assertThat(distance).isEqualTo(0);
        /** WHEN */
        car.setStatus(CarStatus.MOVE);
        int afterDistance = car.getDistance();
        /** THEN */
        assertThat(afterDistance).isEqualTo(1);
        assertThat(afterDistance).isGreaterThan(distance);
    }

    @Test
    void T7_자동차_출력하기() {
        /** GIVEN */
        String carName = "car";
        Car car = new Car(carName);
        /** WHEN */
        car.setStatus(CarStatus.MOVE);
        /** THEN */
        assertThat(car.getDistance()).isEqualTo(1);
        /** WHEN */
        String print = car.print();
        /** THEN */
        assertThat(print).isEqualTo(carName + " : " + Constants.DISTANCE_MARK);
    }

    @Test
    void T8_자동차_반복수행() {
        /** GIVEN */
        Car car = new Car("a");
        int count = 10;
        /** WHEN */
        for(int i = 0; i < count; i++) {
            car.run();
        }
        /** THEN */
        assertThat(car.getDistance()).isLessThanOrEqualTo(count);
    }

}
