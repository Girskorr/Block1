import vertexcover.Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class MyGraph implements Graph {

    ArrayList<ArrayList<Integer>> verList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> valueList = new ArrayList<>();

  //  ArrayList<ArrayList<Integer>> adjmatrix = new ArrayList<>();
    LinkedList<Edge> List = new LinkedList<>();

    int counter = 0;

    public void printGraph () {
        for (int i = 0; i < valueList.size(); i++) {
            System.out.println(valueList.get(i));
        }
    }
        public void printMatrix () {
            for (int i = 0; i < verList.size(); i++) {

                for (int a = 0; a < verList.get(i).size(); a++) {
                        System.out.print(verList.get(a).get(i));
                }
                System.out.println();
            }
        }

   /*
    boolean [] [] adjMatrix;
    Integer [] [] adjMatrixValue;*/
    public MyGraph (String filename, int size) throws IOException {
        valueList.add(new ArrayList<>());
        for (int i = 0; i < verList.size(); i++) {
            verList.get(i).add(0);
        }
        valueList.add(new ArrayList<>());
        for (int i = 0; i < verList.size(); i++) {
            verList.get(i).add(0);
        }

//        BufferedReader objReader = new BufferedReader(new FileReader(filename));
//        String strCurrentLine;
//        while ((strCurrentLine = objReader.readLine()) != null) {
//            if (strCurrentLine != " ") {
//                addVertex(Integer.parseInt(strCurrentLine));
//            }
//        }
    }

    @Override
    //first element of second dimension is the Vertex
    public void addVertex(Integer v) {
        verList.add(new ArrayList<>());
        valueList.add(new ArrayList<>());

        for (int i = 0; i < verList.size(); i++) {
            verList.get(i).add(0);
        }
        for (int i = 0; i < valueList.size(); i++) {
            valueList.get(i).add(0);
        }
        valueList.set(valueList.size() - 1,new ArrayList<>());
      valueList.get(0).set(valueList.get(0).size() - 1,v);
    }

    @Override
    public void addEdge(Integer v, Integer w) {
//        adjList.get(v).(new Node(w));
//        adjList.get(w).(new Node (v));
//        boolean bool;
//        for (int i = 0; i < List.size(); i++) {
//            if (Liste)
//        }
//        Edge edge = new Edge(new Vertex(v),new Vertex(w));
//        List.add(edge);
//        verList.add(new Vertex(w));
//        verList.add((new Vertex(v)));
        int point1 = 0;
        int point2 = 0;
        int point3 = 0;
        int point4 = 0;
        for (int i = 0; i< valueList.size(); i++) {
            for (int a = 0; a < valueList.get(i).size();a++) {
                if (valueList.get(i).get(a) == v) {
                    point1 = i;
                    point2 = a;
                }
                if (valueList.get(i).get(a) == w) {
                    point3 = i;
                    point4 = a;
                }

            }
        }
        //Verbinden
        verList.get(point1).set(point2,1);
        verList.get(point3).set(point4,1);

    }

    @Override
    public void deleteVertex(Integer v) {
//        Vertex ver = new Vertex(v);
//      for (int i = 0; i < List.size(); i++) {
//          if (List.get(i).v.a == v) {
//              List.get(i).v.a = null;
//          }
//          if ( List.get(i).w.a == v) {
//              List.get(i).w.a = null;
//
//          }
//      }
//      if (verList.contains(ver)) {
//          verList.remove(ver);
//      }
        int point1 = 0;
        int point2 = 0;
        for (int i = 0; i< valueList.size(); i++) {
            for (int a = 0; a < valueList.get(i).size();i++) {
                if (valueList.get(i).get(a) == v) {
                    point1 = i;
                    point2 = a;
                }
            }
            valueList.get(point1).remove(point2);

        }
    }

    @Override
    public void deleteEdge(Integer u, Integer v) {
//       for (int i = 0; i < List.size(); i++) {
//           if (List.get(i).v.a == u && List.get(i).w.a == v) {
//               List.remove(i);
//           }
//           if (List.get(i).v.a == v && List.get(i).w.a == u) {
//               List.remove(i);
//           }
//       }
        int point1 = 0;
        int point2 = 0;
        int point3 = 0;
        int point4 = 0;
        for (int i = 0; i < valueList.size(); i++) {
            for (int a = 0; a < valueList.get(i).size(); i++) {
                if (valueList.get(i).get(a) == v) {
                    point1 = i;
                    point2 = a;
                }

                if (valueList.get(i).get(a) == u) {
                    point3 = i;
                    point4 = a;
                }
            }

            verList.get(point1).set(point2, 0);
            verList.get(point3).set(point4, 0);


        }
    }

    @Override
    public boolean contains(Integer v) {
    /*    if (adjList.contains(v)) {
            return true;
        }
        else {
            return false;
        }*/
    return false;
    }

    @Override
    public int degree (Integer v){
            int counter = 0;
            for (int i = 0; i < valueList.size(); i++) {
                for (int a = 0; a < valueList.get(i).size(); i++) {
                    if (valueList.get(i).get(a) == v) {
                        for (int c = 0; c < verList.get(i).size(); c++) {
                            if (verList.get(i).get(a) == 1) {
                                counter++;
                            }
                        }
                    }
                }
            }
            return counter;
        }

    @Override
    public boolean adjacent(Integer v, Integer w) {

        int point1 = 0;
        int point2 = 0;
        int point3 = 0;
        int point4 = 0;
        for (int i = 0; i< valueList.size(); i++) {
            for (int a = 0; a < valueList.get(i).size();i++) {
                if (valueList.get(i).get(a) == v) {
                    point1 = i;
                    point2 = a;
                }
                if (valueList.get(i).get(a) == w) {
                    point3 = i;
                    point4 = a;
                }

            }
        }
        if (verList.get(point1).get(point3) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Graph getCopy() {
        return null;
    }

    @Override
    public Set<Integer> getNeighbors(Integer v) {
//
//        return adjList.get(v);
        for (int i = 0; i < valueList.size(); i++) {
            for (int a = 0; a < valueList.get(i).size(); i++) {
                if (valueList.get(i).get(a) == v) {
                    for (int c = 0; c < verList.get(i).size(); c++) {
                        if (verList.get(i).get(a) == 1) {
                          //  liste.add (valueList.get(i).get(a));
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return verList.size();
    }

    @Override
    public int getEdgeCount() {
        int counter = 0;
        for (int i = 0; i < verList.size(); i++) {
            for (int a = 0; a < verList.get(i).size(); i++) {
               if (verList.get(i).get(a) == 1) {
                   counter++;

               }
            }
        }
        return counter / 2;
    }

    @Override
    public Set<Integer> getVertices() {
        return null;
    }
}
