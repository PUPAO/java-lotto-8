package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        OutputController outputController = new OutputController();

        // 로또 구매
        int count;
        int input;
        while (true) {
            try {
                outputController.printPurchaseAmount();
                input = inputController.inputMoney();
                count = input / 1000;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        outputController.printPurchaseLotto(count);
        LottoMachine machine = new LottoMachine();

        // 로또 객체 생성
        Lotto[] lottoList = machine.createLottoMachine(count);
        outputController.printLottoList(lottoList);

        // 당첨 번호
        outputController.printWinningNumbers();
        List<Integer> winningNumbers = inputController.inputWinningNumbers();

        // 보너스 번호
        outputController.printBonusNumbers();
        int bonusNumber = inputController.inputBonusNumber();

        // 결과 계산
        Map<Rank, Integer> result = machine.checkResult(winningNumbers, bonusNumber);

        // 결과 출력
        outputController.printResult(result, input);
    }
}
