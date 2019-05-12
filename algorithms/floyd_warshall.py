def floyd_warshall_naive(graph):
    size = len(graph)

    for k in range(size):
        for i in range(size):
            for j in range(size):
                graph[i][j] = min(graph[i][j],graph[i][k]+graph[k][j])
    for i in range(size):
        if graph[i][i] < 0:
            return False
    return graph
