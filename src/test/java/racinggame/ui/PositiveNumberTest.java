package racinggame.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName : racinggame.ui
 * fileName : PositiveNumberTest
 * author : haedoang
 * date : 2021-10-12
 * description :
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PositiveNumberTest {

    @Test
    void T1_자연수검증() {
        /** GIVEN */
        int positive = 5;
        int negative = -5;
        int zero = 0;
        /** WHEN */
        PositiveNumber positiveNumber = new PositiveNumber(positive);
        /**THEN */
        assertThat(positiveNumber.getNo()).isEqualTo(positive);
        assertThatThrownBy(() -> new PositiveNumber(negative)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력이 가능합니다.");
        assertThatThrownBy(() -> new PositiveNumber(zero)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력이 가능합니다.");
    }

}
