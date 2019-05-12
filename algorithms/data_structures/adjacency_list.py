from __future__ import print_function

from adjacency_matrix import build_random_graph
from random import uniform,randint

def print_list(graph):
    for key in graph.keys():
        print(str(key))
        print(graph[key])


def build_random_list(m,duplicates = False, low_weight = 1,high_weight = 20,p_edge = .6):
    # graph = dict()
    graph = [None]*m
    if duplicates:
        for i in range(m):
            graph[i] = []
    else:
        for i in range(m):
            graph[i] = dict()

    total_edges = int(m*m*p_edge)
    for i in range(total_edges):
        source = dest = 0
        if duplicates:
            while source == dest:
                source = randint(0,m-1)
                dest = randint(0,m-1)
            weight = randint(low_weight,high_weight)
            graph[source].append((randint(low_weight,high_weight),dest))
        else:
            while source == dest:
                source = randint(0,m-1)
                dest = randint(0,m-1)
                if dest not in graph[source]:
                    graph[source][dest] = randint(low_weight,high_weight)
                else:
                    source = dest = 0
    return graph

MAX_INT = 10000
def matrix_to_list(matrix):
    m = len(matrix)
    graph = dict()
    for i in range(m):
        graph[i] = dict()
    for i in range(m):
        for j in range(m):
            if matrix[i][j] != MAX_INT and matrix[i][j] != 0:
                graph[i][j] = matrix[i][j]
    return graph
