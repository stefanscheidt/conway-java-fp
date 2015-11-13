package conway;

import org.junit.Test;

import static conway.Location.loc;
import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    @Test
    public void neighbours() {
        assertThat(loc(0, 0).neighbours()).containsOnly(
                loc(-1, -1), loc(-1, 0), loc(-1, 1),
                loc(0, -1), loc(0, 1),
                loc(1, -1), loc(1, 0), loc(1, 1));
    }

}
