from __future__ import print_function, division


##implementing a heap function in python
##copied with some modifications for dijkstra from here: http://www.cs.toronto.edu/~david/courses/csc148_f14/week9/heap.py

'''
class Node:
    def __init__(self,data=None):
        self.data = data
        self.leftchild = None
        self.rightchild = None
        self.root = None
    def get_data(self):
        return self.data
'''

class Heap:
    def __init__(self):
        self.array = []
        self.size = 0
    
    def insert(self,value):
        self.array.append(value)
        self.bubble_up(self.size)
        self.size += 1

    def pop(self):
        value = self.array[0]
        self.array.pop(0)
        self.size -= 1
        self.bubble_down(0)
        return value
    
    def decrease_priority(self,v, replace):
        #TODO(jg): can this be implemented with a hashtable
        #          seems kind of fishy to do it this way.
        
        #what do we need to do with this function?
        # -- we need to find a node and replace it's cost with an updated cost
        # v is the index of the node replace is the value


        # 0 1 2 3 4 5 6 7 8 9 10
        # 0 12 34  1000 1000 1000


        for i in reversed(xrange(len(self.array))):
            if self.array[i][1] == v:
                self.array[i] = (replace,v)
                self.bubble_up(i)
                return

    def bubble_up(self,position):
        if position == 0:
            return
        parent = self.get_parent(position)
        if self.array[position] < self.array[parent]:
            self.swap(position,parent)
            self.bubble_up(parent)

    def get_parent(self,position):
        if position == 1 or position == 2:
            return 0
        if position % 2 == 0:
            return (position-2)//2
        else:
            return (position-1)//2

    def bubble_down(self,position):
        children = self.get_children(position)
        if children == []:
            return
        elif len(children) == 1:
            if self.array[children[0]] < self.array[position]:
                self.swap(children[0],position)
                self.bubble_down(children[0])
        else:
            left_val = self.array[children[0]]
            right_val = self.array[children[1]]
            root = self.array[position]

            if left_val < root or right_val < root:
                if left_val < right_val:
                    self.swap(children[0],position)
                    self.bubble_down(children[0])
                else:
                    self.swap(children[1],position)
                    self.bubble_down(children[1])
    
    def swap(self,p1,p2):
        tmp = self.array[p1]
        self.array[p1] = self.array[p2]
        self.array[p2] = tmp

    def get_children(self,position):
        if self.size <= (2*position+1):
            return []
        elif self.size  == (2*position+2):
            return [2*position+1]
        else:
            return [2*position+1,2*position+2]
    

if __name__ == '__main__':
    h = Heap()
    for i in [20,13,1,34,12,14,16,18]:
        h.insert(i)
    for i in range(8):
        print(h.array)
        print(h.pop())
        print(h.array)


