from __future__ import print_function
MAX_INT = 10000
def dijkstra_list_naive(graph,source):
    n_nodes = len(graph)

    dist = [MAX_INT] * n_nodes
    prev = [None] * n_nodes
    dist[source] = 0
    Q = [True] * n_nodes
    
    while sum(Q) != 0:
        val, u = min((val, idx) if Q[idx] else (MAX_INT,MAX_INT) for (idx, val) in enumerate(dist))
        Q[u] = False
        
        neighbors = graph[u]

        for v in neighbors.keys():
            if Q[v]:
                alt = dist[u] + neighbors[v]
                if alt < dist[v]:
                    dist[v] = alt
                    prev[v] = u

    return (dist,prev)
            


    
