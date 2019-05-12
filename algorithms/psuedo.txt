
dijkstra_lists(Graph graph, integer source)
	let q[0...m-1] be an new array
	let dist[0...m-1] be a new array
	let prev[0...m-1] be a new array

	initialize all values in q to True
	initilaize all values in distance to infinity
	initialize all values in prev to -1

	dist[source] = 0

	while all indicies in q are not False:
		u = find the node with the minimum distance by scanning dist
		Q[u] = False
		for each neighbor v of u:
			if Q[v] == True:
				alt_distance = dist[u] + edge(u,v)
				if alt < dist[v]
					dist[v] = alt
					prev[v] = u

dijkstra_fib(Graph graph, integer source)
	let dist[0...m-1] be a new array
	let prev[0...m-1] be a new array

	initilaize all values in distance to infinity
	initialize all values in prev to -1
	dist[source] = 0

	let fHeap be a new Fibonacci Heap

	for each node i in the graph:
		enqueue i with their corresponding distance dist[i]

	while fHeap is not empty:
		u = fHeap.pop()

		for each neighbor v of u:
			alt_distance = dist[u] + edge(u,v)
			if alt < dist[v]
				dist[v] = alt
				prev[v] = u
				decrease priority of node v to alt

dijkstra_heap(Graph graph, integer source)
	# http://ezekiel.vancouver.wsu.edu/~cs223/lectures/graphs/search/dijkstra/dijkstra.pdf
	let dist[0...m-1] be a new array
	let prev[0...m-1] be a new array

	initilaize all values in distance to infinity
	initialize all values in prev to -1
	dist[source] = 0

	let pq be a priority queue which sorts first by their distance and second by their index

	enqueue source node and distance

	while pq is not empty:
		Node = pq.pop()
		let v be the node index and stored_dist be the distance to v stored in queue

		if dist[v] >= stored_dist or v == source
			for each neighbor w of u: 

				alt_distance = dist[v] + edge(v,w)

				if alt_distance < dist[w]
					dist[w] = alt_distance
					prev[w] = v
					enqueue node with index w and with distance alt_distance

bellman_naive(Graph graph, integer source):
	let dist[0...m-1] be a new array
	let prev[0...m-1] be a new array

	initilaize all values in distance to infinity
	initialize all values in prev to -1
	dist[source] = 0

	for relax in range(size-1):
		for every node u in graph
			for each neighbor v of u
				if dist[v] > dist[u] + edge(u,v)
					dist[v] = dist[u] + edge(u,v)

	#check for negative cycles
	for every node u in graph
		for each neighbor v of u
			if dist[v] > dist[u] + edge(u,v)
				we have found a negative cycle

bellman_smarter(Graph graph, integer source)
	# https://gist.github.com/raph-amiard/703936
	let dist[0...m-1] be a new array
	let prev[0...m-1] be a new array
	let closed[0...m-1] be a new array

	initilaize all values in distance to infinity
	initialize all values in prev to -1
	initialize all values in closed to True
	dist[source] = 0
	closed[source] = False

	for relax in range(size-1)
		for every node u in graph where closed[u] == False
			for each neighbor v of u
				if dist[v] > dist[u] + edge(u,v)
					dist[v] = dist[u] + edge(u,v)
					prev[v] = u
					closed[v] = False
		closed[u] = True

	for node u in graph:
		if closed[u] == False
			we have found a negative cycle

floyd_warshal(Graph graph)
	let distances[][] be a copy of the adjacency matrix representing graph

	for k in range(graph)
		for i in range(graph)
			for j in range(graph)
				distances[i][j] = min(graph[i][j,graph[i][k]+graph[k][j]])

	for i in range(graph):
		if graph[i][i] < 0:
			we have found a negative cycle


johnsons(Graph graph)
	let untouchedGraph be a copy of graph

	add a new vertex to graph which has edges to every node with cost 0

	perform bellman on the graph with source as added node

	if bellman finds negative cycles we have found a negative cycle
	else store results as weights

	remove the added edge from the graph

	for every vertex u in the graph
		for every neighbor v of u:
			if weights[u] != infinity and weights[v] != infinity
				#our added node was able to reach both u, v
				edge(u,v) = edge(u,v) + weights[u] - weights[v]

	for each vertex u in graph:
		run dijkstra on graph with source u
		store returned prev[] not dist

	after this is run we should have a matrix (number of nodes x number of nodes) built
	with the previous node for every node stored

	let distances be a matrix size (number of nodes x number of nodes)
	initalize all values in the matrix to be infinity

	if we need to calculate distances:
		for every vertex j in graph
			row = dijkstra_result[j]
			for every vertex i in graph
				iterator = i
				if row[iterator] == -1 
					if and i == j:
						#the path from one node to itself is always zero
						distances[j][i] = 0
					else:
						#the node is unreachable (also coded as -1 in prev)
						distances[j][i] = infinity
				else:
					total_distance = 0
					while(row[iterator] != -1)
						total_distance = total_distance + untouchedGraph[row[iterator]][iterator]
						iterator = row[iterator]
					distances[j][i] = total_distance








