import numpy as np
import matplotlib.pyplot as plt

def basic_plot(functions_name,graph_data,title,x_axis):
    y = graph_data[1]
    x = [data[0] for data in graph_data[0]] #list of list of means
    err = [data[1] for data in graph_data[0]] #list of lists of errs
    plt.figure()
    for idx in range(len(x)):
        plt.errorbar(y,x[idx],yerr = err[idx])

    plt.legend(functions_name)
    plt.title(title)
    plt.xlabel(x_axis)
    plt.ylabel('milliseconds')
    plt.show()

# input data:
# graph_data[1] = y
# graph_data[0] = x,err (mean,std) for each experiment
# so in our case we would have graph_data[0][0][0] = mean and graph_data[0][0][1] = std
# etc.

x = range(10000,100000,10000)
fib_means = []
fib_err = []
heap_means = []
heap_err = []
naive_means = []
naive_err = []
with open('exp2fib_results.csv','rt') as f:
    for line in f:
        f = line.strip()
        row = line.split(',')
        data = [int(i) for i in row]
        fib_means.append(np.mean(data))
        fib_err.append(np.std(data))
with open('exp2heap_results.csv','rt') as f:
    for line in f:
        f = line.strip()
        row = line.split(',')
        data = [int(i) for i in row]
        heap_means.append(np.mean(data))
        heap_err.append(np.std(data))
with open('exp2naive_results.csv','rt') as f:
    for line in f:
        f = line.strip()
        row = line.split(',')
        data = [int(i) for i in row]
        naive_means.append(np.mean(data))
        naive_err.append(np.std(data))        

data = ([[fib_means,fib_err],[heap_means,heap_err],[naive_means,naive_err]],x)

basic_plot(['dijkstra fib','dijkstra heap','dijkstra naive(list)'],data,
    'comparison of heap,fibonacci heap and naive run time with graph sizes 10,000 to 100,000 with p_edge = 0.0001','graph size')
