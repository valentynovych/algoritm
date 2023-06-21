package navigator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    private final String name;
    private List<Node> shortestPart;
    private Integer distance;
    Map<Node, Integer> adjacentNodes;

    public Node(String name) {
        this.name = name;
        this.shortestPart = new LinkedList<>();
        this.adjacentNodes = new HashMap<>();
        this.distance = Integer.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public List<Node> getShortestPart() {
        return shortestPart;
    }

    public void setShortestPart(List<Node> shortestPart) {
        this.shortestPart = shortestPart;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
}
