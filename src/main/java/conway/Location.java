package conway;

import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;

public class Location {

    public static Location loc(int x, int y) {
        return new Location(x, y);
    }

    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Set<Location> neighbours() {
        return rangeClosed(-1, 1)
                .mapToObj(dx -> rangeClosed(-1, 1)
                        .mapToObj(dy -> loc(x + dx, y + dy)))
                .flatMap(identity())
                .filter(loc -> !loc.equals(this))
                .collect(toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

}
