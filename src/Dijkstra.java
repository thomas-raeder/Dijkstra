
public class Dijkstra {
    private Graph bspGraph = new Graph();
    private List<Vertex> route;
    private double wegLaenge = 0;


    public Dijkstra(Graph pGraph) {
        bspGraph = pGraph;
    }


    private void konstruiereRoute(DijkstraVertex knoten){
        wegLaenge = 0;
        route = new List<Vertex>();
        do {
            route.toFirst();
            route.insert(knoten);
            DijkstraVertex vorgaenger = knoten.getVorgaenger();
            if (vorgaenger!=null) {
                Edge kante = bspGraph.getEdge(knoten, vorgaenger);
                wegLaenge = wegLaenge + kante.getWeight();
                route.next();
            }
            knoten = vorgaenger;
        }
        while (knoten != null);
    }

    public List<Vertex> gibRoute(){
        return route;
    }

    public double gibWeglaenge(){
        return wegLaenge;
    }

    public void zuruecksetzen() {
        List<Vertex> knoten = bspGraph.getVertices();
        knoten.toFirst();
        while (knoten.hasAccess()) {
            DijkstraVertex djk = (DijkstraVertex)knoten.getContent();
            djk.setVorgaenger(null);
            djk.setDistanz(-1);
            djk.setMark(false);
            knoten.next();
        }
    }


    public void findeKuerzestenWegDijkstra(String start, String ziel){
        zuruecksetzen();
        DijkstraVertex startKnoten = (DijkstraVertex)bspGraph.getVertex(start);
        DijkstraVertex zielKnoten = (DijkstraVertex)bspGraph.getVertex(ziel);
        findeKuerzestenWeg(startKnoten, zielKnoten);
    }
    public void findeKuerzestenWeg(DijkstraVertex pStart, DijkstraVertex pZiel) {
        if (pStart != null && pZiel != null) {
            PrioritaetsSchlange schlange = new PrioritaetsSchlange();
            pStart.setDistanz(0);
            schlange.enqueue(pStart);
            DijkstraVertex nachbarKnoten = null;
            DijkstraVertex ersterKnoten = null;
            while (!schlange.isEmpty() && ersterKnoten != pZiel) {
                ersterKnoten = (DijkstraVertex) schlange.front();
                schlange.dequeue();
                if (!ersterKnoten.isMarked()) {
                    ersterKnoten.setMark(true);
                    List<Vertex> nachbarListe = bspGraph.getNeighbours(ersterKnoten);
                    nachbarListe.toFirst();
                    while (nachbarListe.hasAccess()) {
                        nachbarKnoten = (DijkstraVertex) nachbarListe.getContent();
                        Edge kante = bspGraph.getEdge(nachbarKnoten,
                                ersterKnoten);
                        double gewicht = kante.getWeight();
                        if (nachbarKnoten.getDistanz() == -1
                                || nachbarKnoten.getDistanz() > ersterKnoten.getDistanz() + gewicht) {
                            nachbarKnoten.setDistanz(ersterKnoten.getDistanz() + gewicht);
                            nachbarKnoten.setVorgaenger(ersterKnoten);
                            schlange.enqueue(nachbarKnoten);
                        }
                        nachbarListe.next();
                    }
                }
            }
            konstruiereRoute(pZiel);
        }
    }


}
