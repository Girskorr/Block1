import java.io.IOException;

public class main {

    public static void main (String [] args) throws IOException {
        MyGraph graph = new MyGraph("C:\\Users\\Julius\\Downloads\\bio-dmelamtx.sec" , 1);
            graph.addVertex(213);
        graph.addVertex(645);
        graph.addVertex(21321);
        graph.addVertex(23);graph.addVertex(1);graph.addVertex(2);
        graph.addEdge(23,2);
        graph.addEdge(645,213);
        graph.addEdge(21321, 645);
        graph.printGraph();
        graph.printMatrix();
        System.out.println(graph.degree(23));




    }
}
