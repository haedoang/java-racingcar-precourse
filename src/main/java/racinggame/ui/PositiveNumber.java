package racinggame.ui;

/**
 * packageName : racinggame.ui
 * fileName : PositiveNumber
 * author : haedoang
 * date : 2021-10-12
 * description :
 */
public class PositiveNumber {
    private static final int MIN_NUMBER = 0;
    private int no;

    public PositiveNumber(int no) {
        if(no <= MIN_NUMBER ) throw new IllegalArgumentException("자연수만 입력이 가능합니다.");
        this.no = no;
    }

    public int getNo() {
        return no;
    }
}
