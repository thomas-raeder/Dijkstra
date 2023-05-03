public class Main {
    public static void main(String[] args) {
        DijkstraGraph program = new DijkstraGraph();
        System.out.println(program.getKuerzesterWeg("B", "G"));
        System.out.println(program.getKuerzesterWeg("H", "A"));
        System.out.println(program.getKuerzesterWeg("C", "C"));
    }
}