package navigator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
    public static Node calculateShortestPart(Node nodeFrom, Node nodeTo) {
        nodeFrom.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(nodeFrom);
        System.out.println("Find minimal distance from: " + nodeFrom.getName() + ", to: " + nodeTo.getName());

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacencyNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacencyNode)) {
                    calculateMinimumDistance(adjacencyNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacencyNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return nodeTo;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluation, Integer edgeWeigh, Node source) {
        Integer sourceDistance = source.getDistance();

        if (sourceDistance + edgeWeigh < evaluation.getDistance()) {
            evaluation.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(source.getShortestPart());
            shortestPath.add(source);
            evaluation.setShortestPart(shortestPath);
        }
    }
}
