from utilities.profiler import do_profile

MAX_INT = 10000

### Idea for different implemetations from here: https://gist.github.com/raph-amiard/703936

#@do_profile()
def bellman_ford_naive(graph,source):
    ##initialize arrays as before
    size = len(graph)
    pred = [None]*size
    min_dist = [MAX_INT]*size
    min_dist[source] = 0

    #relax edges V-1 times to find all shorest paths
    for i in range(1,size-1):
        for v in range(size):
            for x in adj_check(graph,v):
                if min_dist[x] > min_dist[v] + graph[v][x]:
                    min_dist[x] = min_dist[v] + graph[v][x]
                    pred[x] = v
    
    #are there cycles?
    # TODO(jg): There is a bug here. I don't know how to fix it...
    for v in range(size):
        for x in adj_check(graph,v):
            if min_dist[x] > min_dist[v] + graph[v][x]:
                print((v,x))
                print 'negative cycle found'
                #return False
    
    return (min_dist,pred)

def adj_check(G,v):
    result = []
    for x in range(len(G)):
        if G[v][x] != MAX_INT:
            result.append(x)
    return result

def open_check(iterator):
    return [i for i,closed in enumerate(iterator) if not closed]

def bellman_ford_less_naive(graph,source):
    size = len(graph)
    pred = [None] * size
    min_dist = [MAX_INT] * size
    closed = [True] * size
    min_dist[source] = 0
    closed[source] = False

    for _ in range(size):
        for v in open_check(closed):
            # print(v)
            # print(adj_check(graph,v))
            for x in adj_check(graph,v):
                if min_dist[x] > min_dist[v] + graph[v][x]:
                    # print('smaller')
                    min_dist[x] = min_dist[v] + graph[v][x]
                    pred[x] = v
                    closed[x] = False
            closed[v] = True

    if sum(closed) != size:
        return False
    else:
        return (min_dist,pred)

    



