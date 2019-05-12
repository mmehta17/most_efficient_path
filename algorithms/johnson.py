from bellman_ford import bellman_ford_less_naive
from dijkstra import dijkstra_naive
from data_structures.adjacency_matrix import print_nice
import copy

MAX_INT = 10000

def add_node_graph(graph):
    for i in range(len(graph)):
        graph[i].append(MAX_INT)
    graph.append([0]*(len(graph)+1))
    return graph

def remove_node(graph):
    for i in range(len(graph)):
        graph[i].pop()
    graph.pop()
    return graph
def graph_reweight(graph,h):
    for i in range(len(graph)):
        for j in range(len(graph)):
            if j > i and graph[i][j] != MAX_INT:
                graph[i][j] = graph[i][j]+h[i]-h[j]
            elif j < i and graph[i][j] != MAX_INT:
                graph[i][j] = graph[i][j]+h[j]-h[i]
    return graph

def johnson(graph):
    working_graph = copy.deepcopy(graph)
    size = len(working_graph)
    working_graph = add_node_graph(working_graph)
    print_nice(working_graph)
    h_v = bellman_ford_less_naive(working_graph,size)
    if not h_v:
        return False
    else:
        h_v = h_v[0]
    # next the edges of the original graph are reweighted using the values computed
    # weight(u,v) = weight(u,v) +h(u) - h(v)
    working_graph = remove_node(working_graph)
    working_graph = graph_reweight(working_graph,h_v)
    print_nice(working_graph)
    sol = [dijkstra_naive(working_graph,i)[1] for i in range(size)]    
    
    # where sol is the previous nodes - you still have to rebuild the weights 
    return sol
    
    
