public class BellmanFordEdgeList {
    // A directed edge
    public static class Edge {
      double cost;
      int from, to;
      public Edge(int from, int to, double cost) {
        this.to = to;
        this.from = from;
        this.cost = cost;
      }
    }
    
    public static double[] bellmanFord(Edge[] edges, int V, int start) {
      double[] dist = new double[V];
      java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
      dist[start] = 0;
     
      for (int v = 0; v < V-1; v++)
        for (Edge edge : edges)
          if (dist[edge.from] + edge.cost < dist[edge.to])
            dist[edge.to] = dist[edge.from] + edge.cost;
      
      for (int v = 0; v < V-1; v++)
        for (Edge edge : edges)
          if (dist[edge.from] + edge.cost < dist[edge.to])
            dist[edge.to] = Double.NEGATIVE_INFINITY;
      
      return dist;
    }
    public static void main(String[] args) { 
      int E = 10, V = 9, start = 0;
      Edge [] edges = new Edge[E];
      edges[0] = new Edge(0,1,1);
      edges[1] = new Edge(1,2,1);
      edges[2] = new Edge(2,4,1);
      edges[3] = new Edge(4,3,-3);
      edges[4] = new Edge(3,2,1);
      edges[5] = new Edge(1,5,4);
      edges[6] = new Edge(1,6,4);
      edges[7] = new Edge(5,6,5);
      edges[8] = new Edge(6,7,4);
      edges[9] = new Edge(5,7,3);
      double[] d = bellmanFord(edges, V, start);
      for (int i = 0; i < V; i++)
        System.out.printf("The cost to get from node %d to %d is %.2f\n", start, i, d[i] );
      
    }
  }