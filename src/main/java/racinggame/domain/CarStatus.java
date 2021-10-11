package racinggame.domain;

/**
 * packageName : racinggame.domain
 * fileName : CarStatus
 * author : haedoang
 * date : 2021/10/11
 * description :
 */
public enum CarStatus {
    MOVE, STOP;

    public boolean isMove() {
        return this == MOVE;
    }

    public boolean isStop() {
        return this == STOP;
    }

}
