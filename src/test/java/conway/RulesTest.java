package conway;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RulesTest {

    @Test
    public void willSurvive() {
        Rules rules = new Rules();
        assertThat(rules.willSurvive(1)).isFalse();
        assertThat(rules.willSurvive(2)).isTrue();
        assertThat(rules.willSurvive(3)).isTrue();
        assertThat(rules.willSurvive(4)).isFalse();
    }

    @Test
    public void willSpawn() {
        Rules rules = new Rules();
        assertThat(rules.willSpawn(2)).isFalse();
        assertThat(rules.willSpawn(3)).isTrue();
        assertThat(rules.willSpawn(4)).isFalse();
    }

}
