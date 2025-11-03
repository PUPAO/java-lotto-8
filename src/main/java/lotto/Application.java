package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        OutputController outputController = new OutputController();
        // TODO: 프로그램 구현
        outputController.printPurchaseAmount();
        int input = Integer.parseInt(Console.readLine());
        int count = input / 1000;
        outputController.printPurchaseLotto(count);
        LottoMachine machine = new LottoMachine();
        Lotto[] lottoList = machine.createLottoMachine(count);
        outputController.printLottoList(lottoList);
    }
}
