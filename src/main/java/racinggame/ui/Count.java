package racinggame.ui;

/**
 * packageName : racinggame.ui
 * fileName : Count
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public class Count {
    private static final int MIN_NUMBER = 0;

    private int no;

    public Count(int no) {
        if(no < MIN_NUMBER ) throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        this.no = no;
    }

    public int getNo() {
        return no;
    }
}
