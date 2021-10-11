package racinggame.ui;

import nextstep.utils.Console;
import racinggame.common.Constants;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : racinggame.ui
 * fileName : RacingUI
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class RacingUI {

    public Cars createCars() {
        try {
            System.out.println(Constants.MSG_INPUT_CAR_NAMES);
            String carNames = Console.readLine();
            List<Car> carList = createCarList(carNames);
            return new Cars(carList);
        } catch(IllegalArgumentException e) {
            System.out.println(Constants.MSG_ERROR_TEMPLATE + " " +e.getMessage());
            return createCars();
        } catch(NullPointerException e) {
            System.out.println(Constants.MSG_ERROR_TEMPLATE + " " +e.getMessage());
            return createCars();
        }
    }

    public List<Car> createCarList(String carNames) {
        String[]  carNamesArr = carNames.split(Constants.STRING_SEPARATOR);
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < carNamesArr.length; i++) {
            carList.add(new Car(carNamesArr[i]));
        }
        return carList;
    }

    public int setCount() {
        try {
            System.out.println(Constants.MSG_INPUT_TRY_COUNTS);
            String inputNumber = Console.readLine();
            int parseInt = Integer.parseInt(inputNumber);
            Count count = new Count(parseInt);
            return count.getNo();
        } catch(NumberFormatException e) {
            System.out.println(Constants.MSG_ERROR_TEMPLATE + " " + "숫자만 입력가능합니다.");
            return setCount();
        } catch(IllegalArgumentException e) {
            System.out.println(Constants.MSG_ERROR_TEMPLATE + " " + e.getMessage());
            return setCount();
        } catch(NullPointerException e) {
            System.out.println(Constants.MSG_ERROR_TEMPLATE + " " + e.getMessage());
            return setCount();
        }
    }

    public void play(Cars cars, int count) {
        System.out.println(Constants.MSG_RESULT);
        for(int i = 0; i < count; i++) {
            cars.run();
        }
        System.out.println(Constants.MSG_WINNER_PREFIX + cars.getWinners() + Constants.MSG_WINNER_SUFFIX);
    }



}
