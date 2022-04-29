package week_5;public class BinaryTree {    Node root = null;    // 노드 삽입    public void push(int element) {        // 노드가 null일 때,        if (root == null) {            root = new Node(element);        } else {            Node head = root;            Node currentNode;            while (true) {                currentNode = head;                // 값이 작은 경우 (left)                if (head.value > element) {                    head = head.left;                    if (head == null) {                        currentNode.left = new Node(element);                        break;                    }                // 값이 큰 경우 (right)                } else {                    head = head.right;                    if (head == null) {                        currentNode.right = new Node(element);                        break;                    }                }            }        }    }    // 노드 삭제    public boolean remove(int element) {        Node removeNode = root;        Node parentOfRemoveNode = null;        while (removeNode.value != element) {            parentOfRemoveNode = removeNode;            // 삭제할 값이 현재 노드보다 작을때 (left)            if (removeNode.value > element) {                removeNode = removeNode.left;            } else {                removeNode = removeNode.right;            }            // 대소 비교 탐색 중 leaf node의 경우 탐색 실패            if (removeNode == null) {                return false;            }        }        if (removeNode.left == null && removeNode.right == null) {            // 루트노드인 경우            if (removeNode == root) {                root = null;            } else if (removeNode == parentOfRemoveNode.right) {                parentOfRemoveNode.right = null;            } else {                parentOfRemoveNode.left = null;            }            // 오른쪽 자식 노드만 있는 경우        } else if (removeNode.left == null) {            if (removeNode == root) {                root = removeNode.right;            } else if (removeNode == parentOfRemoveNode.right) {                // 삭제 대상 오른쪽 자식 노드를 삭제 대상 위치에 둠                parentOfRemoveNode.right = removeNode.right;            } else {                parentOfRemoveNode.left = removeNode.right;            }            // 왼쪽 자식 노드만 있는 경우        } else if (removeNode.right == null) {            if (removeNode == root) {                root = removeNode.left;            } else if (removeNode == parentOfRemoveNode.right) {                parentOfRemoveNode.right = removeNode.left;            } else {                //삭제 대상 왼쪽 자식 노드를 삭제 대상 위치에 둠                parentOfRemoveNode.left = removeNode.left;            }            // 두 개의 자식 노드가 존재하는 경우,            // 오른쪽 서브 트리에 있는 가장 작은 값 노드를 올린다.        } else {            // 삭제 대상 노드의 자식 노드 중 대체될 노드를 탐색            Node parentOfReplaceNode = removeNode;            // 삭제 대상의 오른쪽 서브 트리 탐색 지정            Node replaceNode = parentOfReplaceNode.right;            while (replaceNode.left == null) {                // 가장 작은 값을 찾기 위해 왼쪽 자식 탐색                parentOfReplaceNode = replaceNode;                replaceNode = replaceNode.left;            }            if (replaceNode != removeNode.right) {                // 가장 작은 값을 선택하기 때문에 대체 노드의 왼쪽은 빈 노드가 됨                parentOfReplaceNode.left = replaceNode.right;                // 대체할 노드의 오른쪽 자식 노드를 삭제할 노드의 오른쪽으로 지정                replaceNode.right = removeNode.right;            }            // 삭제할 노드가 루트 노드인 경우 대체 노드로 바꿈            if (removeNode == root) {                root = replaceNode;            } else if (removeNode == parentOfRemoveNode.right) {                parentOfRemoveNode.right = replaceNode;            } else {                parentOfRemoveNode.left = replaceNode;            }            // 삭제 대상 노드의 왼쪽 자식을 잇는다.            replaceNode.left = removeNode.left;        }        return true;    }    // 중위 순회    public void inOrderTree(Node root, int depth) {        if(root != null) {            inOrderTree(root.left, depth + 1);            for (int i = 0; i < depth; i++) {                System.out.print("ㄴ");            }            System.out.println(root.value);            inOrderTree(root.right, depth + 1);        }    }    // 후위 순회    public void postOrderTree(Node root, int depth) {        if (root != null) {            postOrderTree(root.left, depth + 1);            postOrderTree(root.right, depth + 1);            for (int i = 0; i < depth; i++) {                System.out.print("ㄴ");            }            System.out.println(root.value);        }    }    // 전위 순회    public void preOrderTree(Node root, int depth) {        if (root != null) {            for (int i = 0; i < depth; i++) {                System.out.print("ㄴ");            }            System.out.println(root.value);            preOrderTree(root.left, depth + 1);            preOrderTree(root.right, depth + 1);        }    }}