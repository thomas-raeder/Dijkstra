public class Main {
    public static void main(String[] args) {
        DijkstraGraph program = new DijkstraGraph();
        System.out.println(program.getKuerzesterWeg("B", "G"));
        program = new DijkstraGraph();
        System.out.println(program.getKuerzesterWeg("H", "A"));
        program = new DijkstraGraph();
        System.out.println(program.getKuerzesterWeg("C", "C"));
    }
}