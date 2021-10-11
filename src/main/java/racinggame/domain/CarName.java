package racinggame.domain;

import java.util.Objects;

/**
 * packageName : racinggame.domain
 * fileName : CarName
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class CarName {
    private final int MIN_CAR_NAME_LENGTH = 1;
    private final int MAX_CAR_NAME_LENGTH = 5;
    private String name;

    public CarName(String name) {
        if(name == null) throw new NullPointerException("null은 허용하지 않습니다.");
        if(name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) throw new IllegalArgumentException("문자열 길이가 올바르지 않습니다.");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }
}
