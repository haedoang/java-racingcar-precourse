package racinggame.domain;

/**
 * packageName : racinggame.domain
 * fileName : CarStatus
 * author : haedoang
 * date : 2021-10-12
 * description :
 */
public enum CarStatus {
    STOP, MOVE;

    public boolean isMove() {
        return this == MOVE;
    }

    public boolean isStop() {
        return this == STOP;
    }
}
