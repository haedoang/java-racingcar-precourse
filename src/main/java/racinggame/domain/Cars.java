package racinggame.domain;

import java.util.*;

import static racinggame.common.Constants.STRING_SEPARATOR;

/**
 * packageName : racinggame.domain
 * fileName : Cars
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class Cars {
    private static final int MIN_COUNT = 1;
    private final List<Car> carList;

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

    /** 가장 높은 distance */
    public int getMaxDistance() {
        int maxDistance = 0;
        for(Car car : carList) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    public String getWinners() {
        int maxDistance = this.getMaxDistance();
        String result = "";
        for(Car car : carList) {
            result += (car.getDistance() == maxDistance) ? (result.length() == 0) ? car.getName() : STRING_SEPARATOR + car.getName() : "";
        }
        return result;
    }

    public void run() {
        for(Car car : carList) {
            car.run();
            car.print();
        }
        System.out.println();
    }

}
