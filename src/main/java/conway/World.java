package conway;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static conway.Location.loc;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class World {

    private Set<Location> locationsOfLivingCells;

    public World(String... rows) {
        this(range(0, rows.length)
                .mapToObj(y -> range(0, rows[y].length())
                        .mapToObj(x -> loc(x, y))
                        .filter(loc -> rows[loc.getY()].charAt(loc.getX()) == 'X'))
                .flatMap(identity())
                .collect(toSet()));
    }

    public World(Set<Location> locationsOfLivingCells) {
        this.locationsOfLivingCells = locationsOfLivingCells;
    }

    public World evolve() {
        Rules rules = new Rules();
        Map<Location, Integer> frequencies = locationsOfLivingCells.stream()
                .map(Location::neighbours)
                .flatMap(Set::stream)
                .collect(toMap(loc -> loc, loc -> 1, (oldVal, newVal) -> oldVal +1 ));
        Set<Location> nextLocationsOfLivingCells = frequencies.keySet().stream()
                .filter(loc -> locationsOfLivingCells.contains(loc) ? rules.willSurvive(frequencies.get(loc)) : rules.willSpawn(frequencies.get(loc)))
                .collect(toSet());
        return new World(nextLocationsOfLivingCells);
    }

    public Set<Location> locationsOfLivingCells() {
        return locationsOfLivingCells;
    }

    public List<String> asStrings(Location upperLeft, Location lowerRight) {
        return rangeClosed(upperLeft.getY(), lowerRight.getY())
                .mapToObj(y -> rangeClosed(upperLeft.getX(), lowerRight.getX())
                        .mapToObj(x -> locationsOfLivingCells.contains(loc(x, y)) ? "X" : ".")
                        .reduce("", (result, symbol) -> result + symbol))
                .collect(toList());
    }

}
