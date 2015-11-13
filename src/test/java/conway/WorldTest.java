package conway;

import org.junit.Test;

import static conway.Location.loc;
import static org.assertj.core.api.Assertions.assertThat;

public class WorldTest {

    @Test
    public void evolve_worldWithoutLivingCells_returnsWorldWithoutLivingCells() {
        World emptyWorld = WorldBuilder.anEmptyWorld();
        assertThat(emptyWorld.evolve().locationsOfLivingCells()).isEmpty();
    }

    @Test
    public void evolve_glider() {
        World world = new World(
                ".X..",
                "..X.",
                "XXX.",
                "....");
        World nextWorld = world.evolve();
        assertThat(nextWorld.asStrings(loc(0, 0), loc(3, 3))).containsOnly(
                "....",
                "X.X.",
                ".XX.",
                ".X..");
    }

    @Test
    public void init_withStrings() {
        World world = new World(
                ".X..",
                "..X.");
        assertThat(world.locationsOfLivingCells()).containsOnly(loc(1, 0), loc(2, 1));
    }

    @Test
    public void asStrings() {
        World world = new World(
                ".X..",
                "..X.");
        assertThat(world.asStrings(loc(-1, -1), loc(3, 2))).containsOnly(
                ".....",
                "..X..",
                "...X.",
                ".....");
    }

}
