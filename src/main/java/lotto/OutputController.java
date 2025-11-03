package lotto;

public class OutputController {

    public void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseLotto(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoList(Lotto[] lottoList){
        for(Lotto lotto : lottoList){
            System.out.println(lotto.getLotto());
        }
    }

}
