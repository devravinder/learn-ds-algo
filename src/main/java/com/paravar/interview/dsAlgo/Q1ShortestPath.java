package com.paravar.interview.dsAlgo;

import java.util.*;

public class Q1ShortestPath {
    public static void main(String[] args) {

        /*
        Greedy Method
           - dijkstra
        * */

        List<List<Edge>> graph=new ArrayList<>();


        graph.add(0, new ArrayList<>());
        graph.add(1, new ArrayList<>());
        graph.add(2, new ArrayList<>());
        graph.add(3, new ArrayList<>());
        graph.add(4, new ArrayList<>());
        graph.add(5, new ArrayList<>());
        graph.add(6, new ArrayList<>());

        //=== edges

        graph.get(0).add(new Edge(1,1));
        graph.get(0).add(new Edge(2,2));

        graph.get(1).add(new Edge(2,3));
        graph.get(1).add(new Edge(4,6));
        graph.get(1).add(new Edge(3,4));


        graph.get(2).add(new Edge(4,4));

        graph.get(3).add(new Edge(1,6));
        graph.get(3).add(new Edge(5,5));

        graph.get(4).add(new Edge(1,6));
        graph.get(4).add(new Edge(2,5));


        int from =0;
        int to = 6;


        System.out.printf("Shortest distance from %d to %d is %d %n", from, to, shortestPath(graph, from, to));




    }

     static int shortestPath(List<List<Edge>> graph, int from, int to){

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
                 /*
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
