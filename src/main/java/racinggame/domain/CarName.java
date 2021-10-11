package racinggame.domain;

/**
 * packageName : racinggame.domain
 * fileName : CarName
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class CarName {
    private final int MIN_LENGTH = 1;
    private final int MAX_LENGTH = 5;
    private String name;

    public CarName(String name) {
        if(name == null) throw new NullPointerException("차 이름은 null값을 가질 수 없습니다.");
        if(name.length() < MIN_LENGTH) throw new IllegalArgumentException("차 이름의 길이가 너무 작습니다.");
        if(name.length() > MAX_LENGTH) throw new IllegalArgumentException("차 이름의 길이가 너무 큽니다.");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
