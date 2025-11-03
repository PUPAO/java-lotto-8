package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputController {

    public int inputMoney() {
        String input = Console.readLine();
        int money = validateInt(input);
        isMultipleOfThousand(money);
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        String[] Parts = Console.readLine().split(",");

        // 숫자인지 검증 & 범위 검증
        List<Integer> winningNumbers = new ArrayList<>();
        for(String str : Parts){
            int i = validateInt(str);
            winningNumbers.add(i);
            validateRange(i);
        }

        // 개수 검증
        validateSeven(winningNumbers);

        return winningNumbers;
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        int bonus = validateInt(bonusNumber);
        validateRange(bonus);
        return bonus;
    }

    private static void isMultipleOfThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하셔야 합니다.");
        }
    }

    private static int validateInt(String input) {
        int money;
        try{
            money = Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.");
        }
        return money;
    }

    private static void validateSeven(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다. (입력 개수: " + numbers.size() + ")");
        }
    }

    private static void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이여야 합니다: " + num);
        }
    }
}
