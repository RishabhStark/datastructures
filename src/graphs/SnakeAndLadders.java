package graphs;

public class SnakeAndLadders {
    public static void main(String[] args) {
        Graph graph=new Graph(50);
        int board[]=new int[50];
        board[2]=13;
        board[5]=2;
        board[9]=18;
        board[18]=11;
        board[17]=-13;
        board[20]=-14;
        board[24]=-8;
        board[25]=-10;
        board[32]=-2;
        board[34]=-22;

        // insert edges
        for(int u=0;u<36;u++) {
           for(int dice=1;dice<=6;dice++) {
               int v=u+dice+board[u+dice];
               graph.addEdge(u,v,false);
           }
        }

        System.out.println(graph.bfsShortestPath(0,36));

    }

}
