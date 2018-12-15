/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

//URL : https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
boolean hasCycle(Node head) {
    Set<Node> visitedNodes = new HashSet();
    boolean isCycle = false;
    if(head != null)
        isCycle = traverse(head, visitedNodes);
    
    return isCycle;
}

boolean traverse(Node node, Set<Node> visitedNodes){
    
    if(visitedNodes.contains(node)){
        return true;
    }
    
    visitedNodes.add(node);
    if(node.next != null){
        return traverse(node.next, visitedNodes);
    }else{
        return false;
    }
    
    
}