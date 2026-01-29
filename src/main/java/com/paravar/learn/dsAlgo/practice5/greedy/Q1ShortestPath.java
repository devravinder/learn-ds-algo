package com.paravar.learn.dsAlgo.practice5.greedy;

import java.util.*;

public class Q1ShortestPath {
    public static void main(String[] args) {

        shortestPathTravel();// Dijkstra’s ( Wighted Graph )
    }
    public static void shortestPathTravel() {

        /*
        Steps:
        - Initialize:
           - Create a distance array dist[] with all values set to infinity (Integer.MAX_VALUE),
               - except the source node, which is set to 0.
           - Use a priority queue (min-heap) to fetch the node with the smallest distance.
              - add the current node-distance

        - Relaxation:
           - For the current node, check all its neighbors. If a shorter path to a neighbor is found, update the distance.

        - Repeat:
           -  Continue until all nodes have been processed or the destination node’s shortest distance is found.

        - Output:
           - The dist[] array contains the shortest distances from the source to all other nodes.


           ------

                (0)
               /   \
              4     2
             /       \
           (1)---1---(2)
             \       /
              5     3
               \   /
                (3)


        */



        List<List<Edge>> graph=new ArrayList<>();


        graph.add(0, new ArrayList<>());
        graph.add(1, new ArrayList<>());
        graph.add(2, new ArrayList<>());
        graph.add(3, new ArrayList<>());

        //=== edges

        graph.get(0).add(new Edge(4,1));
        graph.get(0).add(new Edge(2,2));

        graph.get(1).add(new Edge(1,2));
        graph.get(1).add(new Edge(5,3));


        graph.get(2).add(new Edge(3,3));


        int from =0;
        int to = 3;


        System.out.printf("Shortest distance from %d to %d is %d %n", from, to, dijkstraShortestPath(graph, from, to));


    }



    // dijkstra
    static int dijkstraShortestPath(List<List<Edge>> graph, int from, int to){

        int[] shortestDistances = new int[graph.size()]; // to store shortest distance to a vertex ( index ) from 'from'
        Arrays.fill(shortestDistances, Integer.MAX_VALUE);

        shortestDistances[from]=0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(path->path.distance));

        queue.offer(new Node(0,from));

        while (!queue.isEmpty()){
            Node current = queue.poll(); // gives the nearest Node

            if(current.target == to){
                return current.distance;
            }

            for(Edge neighbour: graph.get(current.target)){

                 /* VV IMP
                  int newDistance = current.distance + neighbour.distance;
                  this won't work...bcz
                  'current' can be reached from multiple vertices at different distances.
                  We should consider only shortest path...that we are storing in shortestDistances
                 * */

                int newDistance = shortestDistances[current.target] + neighbour.distance;

                if(newDistance < shortestDistances[neighbour.target]){
                    shortestDistances[neighbour.target] = newDistance;
                    queue.offer(new Node(newDistance, neighbour.target));

                     /*
                       in queue, we are storing only Node...which are reachable in the shortest path
                       and the shortestDistance is stored shortestDistances
                     * */

                }
            }

        }

        return -1;
    }


    static class Edge{
        int distance;
        int target;

        Edge(int distance, int target){
            this.distance = distance;
            this.target = target;
        }
    }

    /*
     this is to store minDistance/shortestDistance from 'from' vertex
    - we can use int[]...instead of Node
    * */
    static class Node {
        int distance;
        int target;

        public Node(int distance, int target) {
            this.distance = distance;
            this.target = target;
        }
    }



}

