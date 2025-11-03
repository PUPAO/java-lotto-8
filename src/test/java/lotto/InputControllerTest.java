package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputControllerTest {

    @Test
    void 금액_입력_테스트() {
        // given
        System.setIn(new ByteArrayInputStream("10000\n".getBytes()));

        // when
        InputController inputController = new InputController();
        int result = inputController.inputMoney();

        // then
        assertThat(result).isEqualTo(10000);
        Console.close();
    }

    @Test
    void 당첨_번호_입력_테스트() {
        // given
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6".getBytes()));
        List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        InputController inputController = new InputController();
        List<Integer> result = inputController.inputWinningNumbers();

        // then
        assertThat(result).isEqualTo(answer);
        Console.close();
    }

    @Test
    void 보너스_번호_입력_테스트() {
        // given
        System.setIn(new ByteArrayInputStream("7".getBytes()));

        // when
        InputController inputController = new InputController();
        int result = inputController.inputBonusNumber();

        // then
        assertThat(result).isEqualTo(7);
        Console.close();
    }
}