package data;

import data.Graph.node;

public class Pqueue {
	public int size = 0;
	int length = 1;
	node queue[] = new node[length];

	public void insert(node N) {
		queue[size] = N;
		N.heapIndex = size;
		System.out.println("size");
		System.out.println(size);
		buildHeap(size);
		size++;

		if (size == length)
			doubleLength();
	}

	public node getMin() {
		node min;
		if (size != 0)
			min = queue[0];
		else
			min = null;
		queue[0] = queue[size];
		size--;
		heapify(0);
		
		//Re-sizing the heap when less than one-fourth is used. This avoids the repeated re-sizing at size/2
		if (size < length / 4)  
			halfSize();

		return min;
	}

	/* 
	 * Classic heapify function to enforce
	 * heap property top-down
	 */
	private void heapify(int x) {
		int l = leftChild(x);
		int r = rightChild(x);
		
		if(l == -1)
			return;
		
		int min = x;

		if (queue[r].cost < queue[x].cost)
			min = r;
		if (queue[l].cost < queue[min].cost)
			min = l;
		if (min != x) {
			node temp = queue[min];
			queue[min] = queue[x];
			queue[min].heapIndex = x;
			queue[x] = temp;
			queue[x].heapIndex = min;
			heapify(min);
		}
	}


	/*
	 * Classic buildHeap method to enforce heap property 
	 * bottom-up - from the leaves to the root
	 */
	private void buildHeap(int x) {
		int parent = parent(x);
		
		if (parent == -1)
			return;		// Processing root node

		if (queue[x].cost < queue[parent].cost) {
			node temp = queue[x];
			queue[x] = queue[parent];
			queue[x].heapIndex = parent;
			queue[parent] = temp;
			queue[parent].heapIndex = x;
			buildHeap(parent);
		}
	}

	/*
	 * parent, leftChild and rightChild is calculated based on the value of x
	 */
	private int parent(int x) {
		if (x != 0)
			return (int) Math.floor((x - 1) / 2);
		else
			return -1;
	}

	private int leftChild(int x) {
		if (x < size / 2)
			return (2 * x + 1);
		else
			return -1;
	}

	private int rightChild(int x) {
		if (x < size / 2)
			return leftChild(x) + 1;
		else
			return -1;
	}
	
	/*
	 * The queue size increases when the number elements reach a limit. This
	 * process achieves an amortized linear processing time
	 */
	private void doubleLength() {
		node newQ[] = new node[2 * length];
		for (int i = 0; i < length; i++)
			newQ[i] = queue[i];
		length *= 2;
		queue = newQ;
	}
	
	private void halfSize() {
		node newQ[] = new node[length / 2];
		for (int i = 0; i <= size; i++)
			newQ[i] = queue[i];
		queue = newQ;
	}

	public void update(node neighbour) {
		//System.out.println(neighbour.heapIndex);
		buildHeap(neighbour.heapIndex);
	}
}
