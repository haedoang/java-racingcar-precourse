package racinggame.ui;

import nextstep.utils.Console;
import racinggame.common.Constants;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static racinggame.common.Constants.*;

/**
 * packageName : racinggame.ui
 * fileName : RacingUI
 * author : haedoang
 * date : 2021-10-12
 * description :
 */
public class RacingUI implements BaseUI {

    @Override
    public Cars createCars() {
        try {
            System.out.println(MSG_INPUT_CAR_NAMES);
            String carNames = Console.readLine();
            List<Car> carList = createCarList(carNames);
            return new Cars(carList);
        } catch(IllegalArgumentException e) {
            System.out.println(MSG_ERROR_TEMPLATE + " " +e.getMessage());
            return createCars();
        } catch(NullPointerException e) {
            System.out.println(MSG_ERROR_TEMPLATE + " " +e.getMessage());
            return createCars();
        }
    }

    private List<Car> createCarList(String carNames) {
        String[]  carNamesArr = carNames.split(Constants.STRING_SEPARATOR);
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < carNamesArr.length; i++) {
            carList.add(new Car(carNamesArr[i]));
        }
        return carList;
    }

    @Override
    public int setCount() {
        return 0;
    }

    @Override
    public void play() {

    }
}
