package conway;

import java.util.HashSet;
import java.util.Set;

public class World {

    public World evolve() {
        return new World();
    }

    public Set<Location> locationsOfLivingCells() {
        return new HashSet<>();
    }

}
