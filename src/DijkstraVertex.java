
public class DijkstraVertex extends Vertex{

    private double distanz;
    private DijkstraVertex vorgaenger;

    public DijkstraVertex(String id){
        super(id);
        distanz = -1;
        vorgaenger = null;
    }

    public void setDistanz(double distanz) {
        this.distanz = distanz;
    }

    public void setVorgaenger(DijkstraVertex vorgaenger) {
        this.vorgaenger = vorgaenger;
    }

    public double getDistanz() {
        return distanz;
    }

    public DijkstraVertex getVorgaenger() {
        return vorgaenger;
    }

}
