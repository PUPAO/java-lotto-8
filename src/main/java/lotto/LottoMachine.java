package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

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

}
