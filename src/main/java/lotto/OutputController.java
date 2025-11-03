package lotto;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputController {
    private final DecimalFormat df = new DecimalFormat("###,###");

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

    public void printWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(Map<Rank, Integer> result, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        long totalPrize = 0;

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;

            int count = result.getOrDefault(rank, 0);
            totalPrize += (long) count * rank.getPrize();

            if(rank == Rank.FIVE_BONUS){
                System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(rank.getPrize()) + "원) - " + count + "개");
                continue;
            }
            System.out.println(rank.getMatchCount() + "개 일치 (" + df.format(rank.getPrize()) + "원) - " + count + "개");
        }

        double yield = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

}
