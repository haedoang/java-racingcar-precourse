package racinggame.domain;

import racinggame.common.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racinggame.common.Constants.*;

/**
 * packageName : racinggame.domain
 * fileName : Cars
 * author : haedoang
 * date : 2021-10-12
 * description :
 */
public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        if(carList == null) throw new NullPointerException("리스트는 null값일 수 없습니다.");
        if(carList.size() == 0) throw new IllegalArgumentException("리스트의 개수가 작습니다.");
        if(isDuplicate(carList)) throw new IllegalArgumentException("차 이름은 중복이 될 수 없습니다.");
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    /** 중복된 CarName이 있는지 체크 */
    public static boolean isDuplicate(List<Car> carList) {
        Set<String> stringSet = new HashSet<>();
        for(Car car : carList) stringSet.add(car.getName());
        return stringSet.size() != carList.size();
    }

    /** 가장 큰 distance */
    public int getMaxDistance() {
        int maxDistance = 0;
        for(Car car : carList) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    /** Winner print */
    public String getWinners() {
        int maxDistance = this.getMaxDistance();
        StringBuilder result = new StringBuilder();
        for(Car car : carList) {
            result.append((car.getDistance() == maxDistance) ? (result.length() == 0) ? car.getName() : STRING_SEPARATOR + car.getName() : "");
        }
        return result.toString();
    }

    public void run() {
        for(Car car : carList) {
            car.run();
            System.out.println(car.print());
        }
        System.out.println();
    }
}
