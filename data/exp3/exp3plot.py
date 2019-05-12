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
x = []
p = .00001
while(p<.0005):
    x.append(p*100000*100000)
    p+= .00001


x 
fib_means = []
fib_err = []
heap_means = []
heap_err = []
with open('exp3fib_results.csv','rt') as f:
    for line in f:
        f = line.strip()
        row = line.split(',')
        data = [int(i) for i in row]
        fib_means.append(np.mean(data))
        fib_err.append(np.std(data))
with open('exp3heap_results.csv','rt') as f:
    for line in f:
        f = line.strip()
        row = line.split(',')
        data = [int(i) for i in row]
        heap_means.append(np.mean(data))
        heap_err.append(np.std(data))

data = ([[fib_means,fib_err],[heap_means,heap_err]],x)

basic_plot(['dijkstra fib','dijkstra heap'],data,
    'comparison of heap and fibonacci heap run time with graph size of 100,000 nodes and 100,000 edges to 5,000,000 edges','number of edges')
