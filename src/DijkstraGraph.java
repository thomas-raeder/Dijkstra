
public class DijkstraGraph {

    private Graph g;
    private Dijkstra d;

    public DijkstraGraph(){
        g = new Graph();
        graphErzeugen();
        d = new Dijkstra(g);

    }

    public void graphErzeugen(){
        knotenHinzu("A");
        knotenHinzu("B");
        knotenHinzu("C");
        knotenHinzu("D");
        knotenHinzu("E");
        knotenHinzu("F");
        knotenHinzu("G");
        knotenHinzu("H");
        knotenHinzu("I");
        knotenHinzu("J");

        kanteHinzu("A", "B", 20);
        kanteHinzu("A", "F", 125);
        kanteHinzu("B", "E", 30);
        kanteHinzu("B", "C", 30);
        kanteHinzu("C", "D", 40);
        kanteHinzu("D", "E", 50);
        kanteHinzu("E", "F", 100);
        kanteHinzu("F", "G", 15);
        kanteHinzu("D", "H", 30);
        kanteHinzu("D", "I", 70);
        kanteHinzu("E", "I", 46);
        kanteHinzu("F", "I", 60);
        kanteHinzu("F", "J", 15);
        kanteHinzu("G", "J", 45);
        kanteHinzu("I", "J", 10);
    }

    public void knotenHinzu(String id){
        DijkstraVertex knoten = (DijkstraVertex) g.getVertex(id);
        if(knoten == null){
            knoten = new DijkstraVertex(id);
            g.addVertex(knoten);
        }
    }

    public void kanteHinzu(String id1, String id2, double pGewicht){
        DijkstraVertex knoten1 = (DijkstraVertex) g.getVertex(id1);
        DijkstraVertex knoten2 = (DijkstraVertex) g.getVertex(id2);
        if (knoten1 != null && knoten2 != null){
            g.addEdge(new Edge(knoten1, knoten2, pGewicht));
        }
    }

    public String getKuerzesterWeg(String startID, String zielID){
        d.zuruecksetzen();
        d.findeKuerzestenWegDijkstra(startID,zielID);
        List<Vertex> list = d.gibRoute();
        list.toFirst();
        String out = "Der Weg von " + startID + " nach " + zielID + " lautet: \n";
        while(list.hasAccess()){
            out = out + list.getContent().getID() + " ";
            list.next();
        }
        out = out + "\n";
        out = out + "Dieser Weg hat eine Länge von " + d.gibWeglaenge();
        return out;
    }



}
