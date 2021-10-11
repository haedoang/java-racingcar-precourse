package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName : racinggame.domain
 * fileName : CarsTest
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class CarsTest {

    @Test
    void T1_Cars_객체_OK() {
        /** GIVEN */
        List<Car> carList = new ArrayList();
        carList.add(new Car("a"));
        carList.add(new Car("b"));
        carList.add(new Car("c"));

        /** WHEN */
        Cars cars = new Cars(carList);

        /** THEN */
        assertThat(cars.getCarList().size()).isEqualTo(carList.size());
    }

    @Test
    void T2_Cars_객체_NG1() {
        /** GIVEN */
        List<Car> carList = new ArrayList();
        carList.add(new Car("a"));
        carList.add(new Car("b"));
        carList.add(new Car("b"));

        /** THEN */
        assertThatThrownBy(()-> new Cars(carList)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름은 중복이 될 수 없습니다.");
    }

    @Test
    void T3_Cars_객체_NG2() {
        /** GIVEN */
        List<Car> carList = new ArrayList();

        /** THEN */
        assertThatThrownBy(()-> new Cars(carList)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("리스트의 개수가 작습니다.");
    }

    @Test
    void T4_Cars_객체_NG3() {
        /** GIVEN */
        List<Car> carList = null;

        /** THEN */
        assertThatThrownBy(()-> new Cars(carList)).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("리스트는 null값일 수 없습니다.");
    }

    @Test
    void T5_자동차_최대거리구하기() {
        /** GIVEN */
        int count = 10;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("a"));
        carList.add(new Car("b"));
        carList.add(new Car("c"));

        /** WHEN */
        Cars cars = new Cars(carList);

        for(int i = 0; i < count; i++) {
            for(Car car : cars.getCarList()) car.run();
        }

        /** THEN */
        int maxDistance = cars.getMaxDistance();

        for(Car car : cars.getCarList()) {
            assertThat(car.getDistance()).isLessThanOrEqualTo(maxDistance);
        }
    }
}
