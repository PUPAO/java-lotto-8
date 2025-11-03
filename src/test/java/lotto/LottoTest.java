package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 복권에_맞는지_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int count = lotto.matchCount(List.of(6,2,7,4,5,1));

        assertThat(count).isEqualTo(5);
    }

    @Test
    void 보너스_숫자_포함_여부_테스트() {
        Lotto lotto = new Lotto(List.of(7, 1, 6, 5, 3, 4));
        boolean containsBonus = lotto.containsBonus(7);

        assertThat(containsBonus).isEqualTo(true);
    }
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
