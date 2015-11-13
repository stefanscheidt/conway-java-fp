package conway;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WorldTest {

    @Test
    public void evolve_worldWithoutLivingCells_returnsWorldWithoutLivingCells() {
        World emptyWorld = WorldBuilder.anEmptyWorld();
        assertThat(emptyWorld.evolve().locationsOfLivingCells()).isEmpty();
    }

}
