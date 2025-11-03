package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private Lotto[] lottoList;

    public Lotto[] createLottoMachine(int count) {
        lottoList = new Lotto[count];
        // 로또 객체 생성
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList[i] = new Lotto(lottoNumberList);
        }
        return lottoList;
    }


    public Map<Rank, Integer> checkResult(List<Integer> winningNumbers, int bonus) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottoList) {
            int matchCount = lotto.matchCount(winningNumbers);
            boolean hasBonus = lotto.containsBonus(bonus);
            Rank rank = Rank.valueOf(matchCount, hasBonus);

            if (rank != Rank.NONE) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }

        return result;
    }

}
