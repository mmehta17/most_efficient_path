from __future__ import print_function 
import time
import numpy as np
from algorithms.data_structures.adjacency_matrix import build_random_graph
import matplotlib.pyplot as plt






# TODO(jg): implement plotting libraries for all-pairs shortest path



def build_size_data(functions, min_size, max_size,num_iter):
    # need to look at time growth over more complex graphs with set connectivity
    # graph = build_random_graph(m,low_weight = 1,high_weight = 20,p_edge = .6)
    all_data = [ [[],[]] for i in range(len(functions)) ]
    y = []
    for size in range(min_size, max_size+1):
        iters = [ [] for i in range(len(functions)) ]
        y.append(size)
        print(str(size))
        for j in range(num_iter): 
            graph = build_random_graph(size,p_edge = .8)
            for idx,function in enumerate(functions):
                start = time.time()
                function(graph,0)
                elapsed = time.time()-start
                iters[idx].append(elapsed)

        for idx,data in enumerate(iters):
            all_data[idx][0].append(np.mean(data))
            all_data[idx][1].append(np.std(data))
    
    return (all_data,y)


def build_connectivity_data(functions, size, min_p, max_p,step_p,num_iter):
    # need to look at time growth over graph connectivity
    # graph = build_random_graph(50,low_weight = 1,high_weight = 20,p_edge = x)
    all_ps = np.arange(min_p,max_p+step_p,step_p)
    all_data = [ [[],[]] for i in range(len(functions)) ]
    y = []
    for p in all_ps:
        iters = [ [] for i in range(len(functions)) ]
        y.append(p)
        for j in range(num_iter): 
            graph = build_random_graph(size,p_edge = p)
            for idx,function in enumerate(functions):
                start = time.time()
                z = function(graph,0)
                elapsed = time.time()-start
                if z != False:
                    iters[idx].append(elapsed)

        for idx,data in enumerate(iters):
            all_data[idx][0].append(np.mean(data))
            all_data[idx][1].append(np.std(data))

    return (all_data,y)

def basic_plot(functions_name,graph_data,title,x_axis):
    y = graph_data[1]
    x = [data[0] for data in graph_data[0]]
    err = [data[1] for data in graph_data[0]]
    plt.figure()
    for idx in range(len(x)):
        plt.errorbar(y,x[idx],yerr = err[idx])

    plt.legend(functions_name)
    plt.title(title)
    plt.xlabel(x_axis)
    plt.show()




