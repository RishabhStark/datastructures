package graphs;

import java.util.*;

public class Graph {
int cnt=0;
    private ArrayList<ArrayList<Integer>> adj;
    private int v;

    Graph(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(i, new ArrayList<Integer>());
        }
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }

    public void addEdge(int source, int dest, boolean bidir) {
        adj.get(source).add(dest);
        if (bidir) {
            adj.get(dest).add(source);
        }
    }

    public void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.print(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("->" + adj.get(i).get(j));
            }
            System.out.println();
        }


    }
   private void dfs(ArrayList<ArrayList<Integer>> g,boolean[] vis,int node) {
        vis[node]=true;
        for(int i:g.get(node)) {
            if(!vis[i])
            dfs(g,vis,i);
        }

    }

    int connectedComponents() {
        // connected components
        boolean[] vis=new boolean[v];
        int cnt=0;
        for(int i=0;i<v;i++) {
            if(!vis[i]) {
                dfs(adj,vis,i);
                cnt++;
            }
        }
        return cnt;

    }


    public void bfs(int src) {
        boolean vis[] = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        vis[src] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbour : adj.get(node)) {
                if (!vis[neighbour]) {
                    queue.offer(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
    }

    public int bfsShortestPath(int src, int dest) {
        boolean vis[] = new boolean[v];
//        int dist[]=new int[v];
        int parent[] = new int[v]; // to keep track of which node introduced which node
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        parent[src] = -1;
        while (!q.isEmpty()) {
            int current = q.remove();
            if (current == dest) {
                break;
            }
            for (int neighbour : adj.get(current)) {
//                dist[neighbour]=current+1;
                if (!vis[neighbour]) {
                    q.add(neighbour);
                    parent[neighbour] = current;
                    vis[neighbour] = true;
                }
            }
        }
        int cur = dest;
        int distance = 0;
        // Traverse the parent array while we reach the parent node which is marked as -1
        while (parent[cur] != -1) {
            System.out.print(cur + "->");
            cur = parent[cur];
            distance++;
        }
        System.out.print(src + " ");

        return distance;
    }

    public void dfs(int src) {

//        Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
//        Space Complexity: O(V).
//        Since, an extra visited array is needed of size V.

        boolean[] vis = new boolean[v];
        dfsUtil(src, vis);
    }

    private void dfsUtil(int src, boolean vis[]) {
        if (vis[src]) {
            return;
        }
        vis[src] = true;
        System.out.print(src + " ");
        for (int neighbour : adj.get(src)) {
            if (!vis[neighbour]) {
                dfsUtil(neighbour, vis);
            }
        }
    }


    private boolean isCyclicUtil(int src, boolean[] vis, boolean[] rec) {
        if (!vis[src]) {
            rec[src] = true;
            vis[src] = true;
        }
        for (int neighbour : adj.get(src)) {
            if (!vis[neighbour] && isCyclicUtil(neighbour, vis, rec)) { // call dfs only if node is not visited already
                return true;
            } else if (rec[neighbour]) {
                return true;
            }

        }
        rec[src] = false;
        return false;
    }

    public boolean isCyclic(int src) {
        boolean[] vis = new boolean[v];
        boolean[] rec = new boolean[v];
        return isCyclicUtil(src, vis, rec);
    }


    private void topologicalSortUtil(int src, boolean[] vis, Stack<Integer> stack) {
        vis[src] = true; // don't need to check already visited coz topsort is only applicable for DAG
        for (int neighbour : adj.get(src)) {
            if (!vis[neighbour]) {
                // there may be a case when the current node is also neighbour to some other node
                topologicalSortUtil(neighbour, vis, stack);
            }
        }
        stack.push(src);
    }

    public void topologicalSort(int src) {
        boolean[] vis = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            topologicalSortUtil(i, vis, stack);
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }


    public void kahansTopSort() {
        // Create a array to store
        // indegrees of all
        // vertices. Initialize all
        // indegrees as 0.
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            List<Integer> list = new ArrayList<>(adj.get(i));
            for (int node : list) {
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topsort = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Initialize count of visited vertices
        int cnt = 0;
        while (!q.isEmpty()) {
            int u = q.remove();
            topsort.add(u);
            cnt++;
            for (int node : adj.get(u)) {
                if (--indegree[node] == 0) {
                    q.add(node);
                }
            }
        }
        // Check if there was a cycle
        if (cnt != v) {
            System.out.println(
                    "There exists a cycle in the graph");
            return;
        }

        // Print topological order
        for (int i : topsort) {
            System.out.print(i + " ");
        }
    }

    public boolean cycleUndirectedBfs(int src) {
        int[] vis = new int[v];
        Arrays.fill(vis, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        vis[src] = 0;
        while (!q.isEmpty()) {
            int s = q.remove();
            vis[s] = 1;

            for (int neighbor : adj.get(s)) {
                if (vis[neighbor] == -1) {
                    q.add(neighbor);
                    vis[neighbor]=0;
                }
                else if(vis[neighbor]==0) {
                    // means node is already inside queue
                    return true;
                }

            }
        }
        return false;


    }

    public void bridges(int start) {
        int[] vis=new int[v];
        int[] in=new int[v];
        int[] low=new int[v];
        bridgesDfs(start,-1,0,vis,in,low);

    }
    private void bridgesDfs(int node,int parent,int timer,int[] vis,int[] in,int[] low) {
        vis[node]=1;
        in[node]=timer;
        low[node]=timer;
        timer++;
        for(int child:adj.get(node)) {
            if(child==parent) continue;
            if(vis[child]==1) {
                // it's a backedge
                low[node]=Math.min(low[node],in[child]);
            }
            else {
                // it's a forward edge
                bridgesDfs(child,node,timer,vis,in,low);
                low[node]=Math.min(low[node],low[child]);
                if(in[node]<low[child]) {
                    // it's a bridge coz child node can't be reached before without this parent node
                    System.out.println(node+" "+child+" is a bridge");
                }
            }
        }



    }
    public boolean bipartite(int node,int color,boolean[] vis,int[] col) {
        vis[node]=true;
        col[node]=color;
        for(int i:adj.get(node)) {
            if(!vis[i]) {
                if(!bipartite(i,color^1,vis,col)) {
                    return false;
                }
             }
            else {
                if(col[node]==col[i]) {
                return false; }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Graph g = new Graph(4);
        Scanner scanner = new Scanner(System.in);
//        0 1 2 3 3 4 4 2
        g.addEdge( 0, 1);
        g.addEdge( 1, 2);
        g.addEdge( 2, 3);
        g.addEdge(3, 1);
        g.bridges(0);
        System.out.println( g.cycleUndirectedBfs(0));



    }

}







