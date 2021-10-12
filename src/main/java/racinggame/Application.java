package racinggame;

import racinggame.domain.Cars;
import racinggame.ui.BaseUI;
import racinggame.ui.RacingUI;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        BaseUI ui = new RacingUI();
        Cars cars = ui.createCars();
        if(cars == null) return;
        int count = ui.setCount();

        ui.play(cars, count);

    }
}
