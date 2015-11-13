package conway;

public class Rules {

    public boolean willSurvive(int numberOfLivingNeighbours) {
        return numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3;
    }

    public boolean willSpawn(int numberOfLivingNeighbours) {
        return numberOfLivingNeighbours == 3;
    }

}
