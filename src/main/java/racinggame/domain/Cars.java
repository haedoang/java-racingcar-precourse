package racinggame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * packageName : racinggame.domain
 * fileName : Cars
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class Cars {
    private final int MIN_COUNT = 1;
    private List<Car> carList;

    public Cars(List<Car> carList) {
        if(carList == null) throw new NullPointerException("리스트는 null값일 수 없습니다.");
        if(carList.size() < MIN_COUNT) throw new IllegalArgumentException("리스트의 개수가 작습니다.");
        if(isDuplicate(carList)) throw new IllegalArgumentException("차 이름은 중복이 될 수 없습니다.");
        this.carList = carList;
    }

    public static boolean isDuplicate(List<Car> carList) {
        Set<String> stringSet = new HashSet<>();
        for(Car car : carList) stringSet.add(car.getName());
        return stringSet.size() != carList.size();
    }

    public List<Car> getCarList() {
        return carList;
    }

}
