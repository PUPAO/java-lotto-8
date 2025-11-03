package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    private final Lotto[] lottoList;

    public LottoMachine(int count) {
        lottoList = new Lotto[count];
        // 로또 객체 생성
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList[i] = new Lotto(lottoNumberList);
            System.out.println(lottoNumberList.toString());
        }
    }

    /**
     * 테스트용만 사용할 것.
     */
    public Lotto[] getLottoList() {
        return lottoList;
    }

}
