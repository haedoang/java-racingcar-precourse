package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName : racinggame.domain
 * fileName : Car
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class CarTest {

    @Test
    void T1_자동차_객체_생성() {
        Car car = new Car("118d");
        assertThat(car.getName()).isEqualTo(new CarName("118d"));
    }

    @Test
    void T2_자동차이름을_체크한다() {
        String carName = "118d";
        String illegalCarName = "avante";
        String illegalCarName2 = "";
        String illegalCarName3 = null;
        Car car1 = new Car(carName);

        assertThat(car1.getName()).isEqualTo(new CarName(carName));

        assertThatThrownBy(() -> new Car(illegalCarName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 길이가 올바르지 않습니다.");

        assertThatThrownBy(() -> new Car(illegalCarName2)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 길이가 올바르지 않습니다.");

        assertThatThrownBy(() -> new Car(illegalCarName3)).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("null은 허용하지 않습니다.");
    }

    @Test
    void T3_자동차는_움직인거리를가진다() {
        /** GIVEN */
        Car car = new Car("car");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        /** WHEN */
        car.run(CarStatus.STOP);

        /** THEN */
        assertThat(car.getDistance()).isEqualTo(0);

        /** WHEN */
        car2.run(CarStatus.MOVE);
        car2.run(CarStatus.MOVE);
        car3.run(CarStatus.MOVE);
        car3.run(CarStatus.MOVE);
        car3.run(CarStatus.MOVE);
        car3.run(CarStatus.MOVE);

        /** THEN */
        assertThat(car2.getDistance()).isEqualTo(2);
        assertThat(car3.getDistance()).isEqualTo(4);
    }

}


