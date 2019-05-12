from __future__ import print_function,division
from random import uniform, randint
MAX_INT = 10000

def print_nice(m):
    print()
    for i in m:
        for j in i:
            if len(str(j)) > 1:
                print(j,end='  ')
            else:
                print(j,end='   ')
        print()
    print()

def build_random_graph(m,low_weight=1,high_weight=20,p_edge=.6,stress = False):
    #TODO(jg): it is possible to implement a graph which is impossible to find a shortest path.
    #NOTE(jg): I think that I have mitigated this bug.
    matrix = []
    for i in range(m):
        #give each node a 60 percent chance of having a connection with another node
        #and then give it a random weight from 1 to 20
        row = [randint(low_weight,high_weight) if uniform(0,1)<p_edge else MAX_INT for x in range(m)]
        row[i] = 0
        #we need to check to make sure that a node is lonely
        #this makes sure that every node has at leasat one connection with another node
        matrix.append(row)


        if stress:
            #progress tracker - to be removed
            print(str(i)+'\r',end = '')
    return matrix


if __name__ == '__main__':
    graph = build_random_graph(10**3)
    #print_nice(graph)
    dijkstra(graph,15)
    dijkstra_heap(graph,15)



