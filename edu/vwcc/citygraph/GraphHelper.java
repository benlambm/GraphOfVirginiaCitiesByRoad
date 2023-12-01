package edu.vwcc.citygraph;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class GraphHelper {
	private static final Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(
			DefaultWeightedEdge.class);

	// there can be no GraphHelper without its Graph! this constructors populates
	// the graph
	public GraphHelper(Map<String, String[]> map) {
		// add all Cities as vertices
		for (String key : map.keySet()) {
			graph.addVertex(key);
		}

		// process the String array for each key to add Edges next
		for (var entry : map.entrySet()) {
			String cityName = entry.getKey();
			for (String neighbor : entry.getValue()) {
				String[] pair = neighbor.split("-");
				String neighborName = pair[0];
				double distance = Double.parseDouble(pair[1]);

				// Create new Weighted Edge and set its weight to distance in miles
				DefaultWeightedEdge edge = graph.addEdge(cityName, neighborName);
				if (edge != null) {
					graph.setEdgeWeight(edge, distance);
				}
			}
		}
	}

	// performs very basic Data Summary calculations on graph
	public void dataSummary() {
		// let's make it easier to count everything
		Set<String> cities = graph.vertexSet();
		Set<DefaultWeightedEdge> roads = graph.edgeSet();

		// let's calculate some graph stats using streams for practice
		int numberOfRoads = (int) roads.stream().count();
		double totalMiles = roads.stream().mapToDouble(rd -> graph.getEdgeWeight(rd)).sum();
		double avgRoadLength = roads.stream().mapToDouble(rd -> graph.getEdgeWeight(rd)).average().getAsDouble();

		// use another JGraphT class to determine if graph is fully connected
		ConnectivityInspector<String, DefaultWeightedEdge> ci = new ConnectivityInspector<>(graph);
		boolean isFullyConnected = ci.isConnected();

		System.out.println("\nGRAPH DATA SUMMARY:");
		System.out.println("Number of cities in dataset: " + cities.size());
		System.out.println("Total number of connections/roads between them: " + numberOfRoads);
		System.out.println("Total number of miles covered by graph: " + totalMiles);
		System.out.printf("Average distance between cities: %.2f%n", avgRoadLength);
		System.out.println("Graph fully connected? " + isFullyConnected);
		System.out.println();

	}

	// uses Dijkstra's algorithm to determine shortest path
	public void findShortestPath() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nPICK ANY TWO: ");
		System.out.println(graph.vertexSet().stream().collect(Collectors.joining("...")));
		System.out.println("Enter First City Name (Case-sensitive): ");
		String source = scanner.nextLine();
		System.out.println("Enter Second City Name (case-sensitive): ");
		String target = scanner.nextLine();

		// initialize Dijkstra's Shortest Path API from JGraphT
		DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);
		// Find the shortest path
		GraphPath<String, DefaultWeightedEdge> path = dijkstraAlg.getPath(source, target);
		if (path == null) {
			System.out.println("There is no path between " + source + " and " + target);
		} else {
			// Print the shortest path and the total distance
			System.out.println("The shortest path between " + source + " and " + target + " is:\n");
			System.out.println(path.getVertexList().stream().collect(Collectors.joining(" - ")));
			System.out.println("\nThe total distance is " + path.getWeight() + " miles.");
		}
	}

}
