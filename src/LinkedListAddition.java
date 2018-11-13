import org.junit.Test;

/**
 * 链表加法
 * 给出两个数，解析为链表，是用链表进行加法，输出结果用链表表示
 */
public class LinkedListAddition {

    int tenDigits = 0;
    int singleDigits = 0;
    int sum = 0;
    Node node1 = null;
    Node node2 = null;

    @Test
    public void test() {
        int[] value1 = new int[]{6, 7, 8, 9, 3, 2, 5};
        int[] value2 = new int[]{3, 4, 5, 6, 4, 2, 9, 0};
        node1 = buildNodeList(value1);
        node2 = buildNodeList(value2);

        Node result = null;
        result = dealWithDouble(node1, node2, result);

        result = dealWithContinue(node1, node2, result);
        printNode(result, true);
    }

    private Node dealWithContinue(Node node1, Node node2, Node result) {
        if (node1 != null || node2 != null) {
            Node continueNode = node1;
            if (continueNode == null) {
                continueNode = node2;
            }

            continueNode.next = result;
            result.prev = continueNode;
            result = result.prev;

            while (true) {
                sum = (int) result.value + tenDigits;
                tenDigits = sum / 10;
                singleDigits = sum % 10;

                result.value = singleDigits;
                if (result.prev == null) {
                    break;
                }
            }
        }

        if (tenDigits > 0) {
            result = createNewNodeInPre(result, tenDigits);
        }
        return result;
    }

    private Node dealWithDouble(Node node1, Node node2, Node result) {
        while (node1 != null && node2 != null) {
            int node1Value = (int) node1.value;
            int node2Value = (int) node2.value;

            node1 = node1.prev;
            node2 = node2.prev;

            sum = node1Value + node2Value + tenDigits;

            tenDigits = sum / 10;
            singleDigits = sum % 10;

            if (result == null) {
                result = new Node(singleDigits, null, null);
            } else {
                result = createNewNodeInPre(result, singleDigits);
            }
        }
        this.node1 = node1;
        this.node2 = node2;
        return result;
    }

    private Node createNewNodeInPre(Node result, int value) {
        Node temp = new Node(value, null, result);
        result.prev = temp;
        return result.prev;
    }

    public Node printNode(Node node, boolean order) {
        Node result = node;
        while (node != null) {
            System.out.print(node.value + " -- ");
            if (order) {
                node = node.next;
            } else {
                node = node.prev;
            }
        }
        return result;
    }

    public Node buildNodeList(int[] value) {
        Node result = null;
        for (int i = 0; i < value.length; i++) {
            if (result == null) {
                result = new Node(value[i], null, null);
            } else {
                Node temp = new Node(value[i], result, null);
                result.next = temp;
                result = result.next;
            }
        }
        return result;
    }

}

class Node<E> {
    public Node prev;
    public Node next;
    public E value;

    Node(E value, Node pre, Node next) {
        this.next = next;
        this.prev = pre;
        this.value = value;
    }
}