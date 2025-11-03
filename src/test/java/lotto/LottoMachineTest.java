package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @Test
    void 로또_발행_테스트() {
        // given
        int count = 8;

        // when
        LottoMachine machine = new LottoMachine(count);

        // then
        assertThat(machine.getLottoList()).hasSize(count);
    }
}