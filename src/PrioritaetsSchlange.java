
public class PrioritaetsSchlange{

    private List<DijkstraVertex> schlange;

    public PrioritaetsSchlange(){
        schlange = new List<>();
    }

    public void enqueue(DijkstraVertex knoten){
        if (schlange.isEmpty()){
            schlange.append(knoten);
        } else {
            boolean einsortiert = false;
            schlange.toFirst();
            while(!einsortiert && schlange.hasAccess()){
                DijkstraVertex akt = schlange.getContent();
                if (akt.getDistanz() < knoten.getDistanz()){
                    schlange.next();
                } else {
                    schlange.insert(knoten);
                    einsortiert = true;
                }
            }
            if (!einsortiert){
                schlange.append(knoten);
            }
        }
    }

    public DijkstraVertex front(){
        if(schlange.isEmpty()){
            return null;
        } else {
            schlange.toFirst();
            return schlange.getContent();
        }
    }

    public void dequeue(){
        schlange.toFirst();
        if (schlange.hasAccess()){
            schlange.remove();
        }
    }

    public boolean isEmpty(){
        return schlange.isEmpty();
    }

}
