from fib import *
import copy
class Fib_Heap():
    def __init__(self):
        self.heap = FibonacciHeap()

    def add(self,data):
        n = make_node(data)
        insert(self.heap,n)
    
    def pop(self):
        return extract(self.heap)
    def adjust_node(self,node,alt):
        decrease_key(self.heap,node,(alt,node.key[1]))
    def print_nice(self):
        return print_heap(self.heap.min)
    def get_nodes(self):
        return iterate_heap(self.heap.min)     
