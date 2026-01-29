
/*
 Farthest Nodes
 Have the function FarthestNodes(strArr) read strArr,
   which will be an array of hyphenated letters representing paths between two nodes.

 For example:
 ["a-b", "b-c", "b-d"]
 means that there is a path from node a to b (and b to a), b to c, and b to d.

 Your program should determine the longest path that exists in the graph and return the length of that path.

 For the example above, your program should return 2, because of the paths a-b-c and d-b-c.

 The path a-b-c also means that there is a path c-b-a.

 No cycles will exist in the graph.
 Every node will be connected to some other node in the graph.
 Examples
 Example 1
 Input:
 ["b-e", "b-c", "c-d", "a-b", "e-f"]
 Output:
 4

 Example 2
 Input:
 ["b-a", "c-e", "b-c", "d-c"]
 Output:
 3
*/

// find the diameter of graph
function FarthestNodes(strArr) {
    // Build adjacency list from input
    let graph = {};

    for (let edge of strArr) {
        let [a, b] = edge.split("-");
        if (!graph[a]) graph[a] = [];
        if (!graph[b]) graph[b] = [];
        graph[a].push(b);
        graph[b].push(a);
    }

    // Function to find the farthest node and distance using BFS
    function bfs(start) {
        let queue = [[start, 0]]; // to store node & distance
        let visited = new Set();
        visited.add(start);
        let farthestNode = start;
        let maxDistance = 0;

        while (queue.length > 0) {
            let [node, dist] = queue.shift();
            if (dist > maxDistance) {
                maxDistance = dist;
                farthestNode = node;
            }
            for (let neighbor of graph[node]) {
                if (!visited.has(neighbor)) {
                    visited.add(neighbor);
                    queue.push([neighbor, dist + 1]);
                    // queue.push([neighbor, dist + weight]); // if weighted graph
                }
            }
        }
        return { node: farthestNode, distance: maxDistance };
    }

    // Start BFS from an arbitrary node (first key in graph)
    let firstNode = Object.keys(graph)[0]; // *** Imp
    let farthestFromFirst = bfs(firstNode); // *** Imp

    // Run BFS from the farthest found node to get the diameter
    let result = bfs(farthestFromFirst.node);

    return result.distance;
}

// Test Cases
console.log(FarthestNodes(["b-e", "b-c", "c-d", "a-b", "e-f"])); // Output: 4
console.log(FarthestNodes(["b-a", "c-e", "b-c", "d-c"])); // Output: 3
