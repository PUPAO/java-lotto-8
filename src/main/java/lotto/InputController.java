package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputController {

    public int inputMoney() {
        int input = Integer.parseInt(Console.readLine());
        return input;
    }

    public List<Integer> inputWinningNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
