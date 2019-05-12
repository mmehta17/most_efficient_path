from __future__ import print_function,division

from data_structures.heap import Heap
from data_structures.fib_wrapper import Fib_Heap

from utilities.profiler import do_profile

MAX_INT = 10000


#@do_profile()
def dijkstra_naive(graph,source):
    n_nodes = len(graph)

    Q = [True] * n_nodes
    dist = [MAX_INT] * n_nodes  #distance from source to v
    prev = [None] * n_nodes #previous node in optimal path

    dist[source] = 0

    while sum(Q) != 0:
        #find vertex with minimum distance
        #print(Q)
        before = sum(Q)
        #NOTE(jg): This is the most important line in the algorithm and is where other
        #          Data structures are implemented
        val, u = min((val, idx) if Q[idx] else (MAX_INT,-1) for (idx, val) in enumerate(dist))
        Q[u] = False #remove from list
        after = sum(Q)
        if before == after:
            return (False,False)
        weights = graph[u]

        for v,edge in enumerate(weights):
            if edge != MAX_INT and Q[v]: #v is in Q and is neighbor
                alt = dist[u] + edge #alternative path
                if alt < dist[v]: #alternative path is better
                    dist[v] = alt
                    prev[v] = u
    return (dist,prev)

def dijkstra_fib(graph,source,stress = False):
    n_nodes = len(graph)
    Q = [True] * n_nodes
    dist = [MAX_INT] * n_nodes  #distance from source to v
    prev = [None] * n_nodes #previous node in optimal path
    dist[source] = 0
    
    H = Fib_Heap()

    for node,distance in enumerate(dist):
        H.add((distance,node))

    while H.heap.n != 0:
        #print(H.heap.n)
        
        dist_u, u = H.pop().key
        Q[u] = False
        weights = graph[u]
        
        
        # TODO(jkg): get_nodes is SUPER slow. need to fix
        for heap_node in H.get_nodes():
            v = heap_node.key[1]
            edge = weights[v]
            if edge != MAX_INT: #v is in Q and is neighbor
                #we need some way of relating this to the heap 
                alt = dist_u + edge #alternative path
                if alt < dist[v]: #alternative path is better
                    dist[v] = alt
                    prev[v] = u
                    H.adjust_node(heap_node,alt)
        if stress:
            #progress tracker - to be removed
            print(str(S.size)+'\r',end = '')
    return (dist,prev)

def dijkstra_heap(graph,source,stress = False):
    n_nodes = len(graph)
    Q = [True] * n_nodes
    dist = [MAX_INT] * n_nodes  #distance from source to v
    prev = [None] * n_nodes #previous node in optimal path
    dist[source] = 0
    S = Heap()

    for node,distance in enumerate(dist):
        S.insert((distance,node))

    while S.size != 0:
        #find vertex with minimum distance
        dist_u , u = S.pop() #instead of finding the minimum we just grab it. O(logn) vs O(n)
        Q[u] = False

        weights = graph[u]
        
        for v,edge in enumerate(weights):
            
            # can I find a way to relate this to the decrease priority?
            # yes. we need to iterate the heap itself and not the weight array

            
            if edge != MAX_INT and Q[v]: #v is in Q and is neighbor
                #we need some way of relating this to the heap
                
                alt = dist_u + edge #alternative path
                if alt < dist[v]: #alternative path is better
                    dist[v] = alt
                    prev[v] = u
                    S.decrease_priority(v,alt)
        if stress:
            #progress tracker - to be removed
            print(str(S.size)+'\r',end = '')
    return (dist,prev)

import heapq

def dijkstra_fastest(graph,source):
    n_nodes = len(graph)
    node_heap = []
    
    Q = [True] * n_nodes
    dist = [MAX_INT]* n_nodes
    prev = [None]* n_nodes
    dist[source] = 0
    
    for idx,val in enumerate(dist):
        heapq.heappush(node_heap,(val,idx))

    while len(node_heap) > 0:
        dist_u, u = heapq.heappop(node_heap)
        Q[u] = False

        weights = graph[u]

        for v,edge in enumerate(weights):
            if edge != MAX_INT and Q[v]:
                alt = dist_u + edge #alternative path
                if alt < dist[v]: #alternative path is better
                    dist[v] = alt
                    prev[v] = u
                    node_heap[v] = (alt,v)
                    heapq.heapify(node_heap)

        return (dist,prev)


if __name__ == '__main__':
    graph = build_random_graph(20)
    print(dijkstra_heap(graph,10))
