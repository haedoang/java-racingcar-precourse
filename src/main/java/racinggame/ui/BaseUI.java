package racinggame.ui;

import racinggame.domain.Cars;

/**
 * packageName : racinggame
 * fileName : BaseUI
 * author : haedoang
 * date : 2021-10-12
 * description :
 */
public interface BaseUI {

    Cars createCars();

    int setCount();

    void play();
}
