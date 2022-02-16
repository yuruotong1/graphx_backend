package com.dongle.graphx.Domain;

import lombok.Data;

@Data
public class Edge {
    private String type = "";
    private String text = "";
    private Node sourceNode;
    private Node targetNode;

}
