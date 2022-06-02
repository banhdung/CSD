/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author admin
 */
public class MyList {

    Node head;
    Node tail;

    public MyList() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    Node beforeNode(Node q) {
        Node f = head;
        while (f.next != q) {
            f = f.next;
        }
        return f;
    }

    void remove(Node q) {
        if (isEmpty()) {
            return;
        }
        if (q == head) {
            head = q.next;
            return;
        }
        if (q == null) {
            return;
        }
        beforeNode(q).next = q.next;
    }

    void addToHead(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    void addToTail(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    void addAfter(Node p, int x) {
        Node p1 = new Node(x);
        if (isEmpty()) {
            return;
        }
        p1.next = p.next;
        p.next = p1;
        if (p == tail) {
            tail = p1;
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println("");
    }

    void delFromHead() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void delFromTail() {
        Node p = head;
        if (isEmpty()) {
            return;
        }
        if (head == tail && head != null) {
            head = tail = null;
        }
        while (p.next != null) {
            p = p.next;
            if (p.next == tail) {
                p.next = null;
                tail = p;
            }
        }
    }

    void delAfter(Node p) {
        if (isEmpty() || head == tail || p == tail) {
            return;
        }
        p.next = p.next.next;
    }

    void delete(int x) {
        Node p = head;
        if (isEmpty()) {
            return;
        }
        while (p.next != null) {
            if (p.info == x) {
                remove(p);
                break;
            }
            p = p.next;
        }
    }
    
    Node search(int x) {
        Node p = head;
        while (p != null) {
            if (p.info == x) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    int count() {
        Node p = head;
        int count = 1;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    void dele(int i) {
        Node p = head;
        int count = 0;
        while (p.next != null) {
            count++;
            if (count == i) {
                remove(p);
            }
            p = p.next;
        }
    }

    void sort() {
        Node i;
        Node j;
        Node tmp = new Node(0);
        for (i = head; i != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                if (i.info > j.info) {
                    tmp.info = i.info;
                    i.info = j.info;
                    j.info = tmp.info;
                }
            }
        }
    }

    int max() {
        Node p = head;
        int max = p.info;
        while (p.next != null) {
            if (p.next.info > max) {
                max = p.next.info;
            }
            p = p.next;
        }
        return max;
    }

    int min() {
        Node p = head;
        int min = p.info;
        while (p.next != null) {
            if (p.next.info < min) {
                min = p.next.info;
            }
            p = p.next;
        }
        return min;
    }

    int sum() {
        Node p = head;
        int sum = p.info;
        while (p.next != null) {
            sum += p.next.info;
            p = p.next;
        }
        return sum;
    }

    int avg() {
        return sum() / count();
    }

    boolean sorted() {
        Node p = head;
        int count = 0;
        while (p.next != null) {            
            if (p.info > p.next.info) {
                count++;
            }
            p = p.next;
        }
        if (count == count() - 1) {
            return true;
        }
        p = head;
        count = 0;
        while (p.next != null) {            
            if (p.info <= p.next.info) {
                count++;
            }
            p = p.next;
        }
        return count == count() - 1;
    }
    
    int[] toArray() {
        Node p;
        int i = 0;
        for (p = head; p != null; p = p.next) {
            i++;
        }
        int[] arr = new int[i];
        int j = 0;
        if (isEmpty()) {
            return null;
        }
        for (p = head; p != null; p = p.next) {
            arr[j] = p.info;
            j++;
        }
        return arr;
    }

    void merge (MyList list1, MyList list2) {
        list1.sort();list2.sort();
        Node p = list1.head;
        while (p != null) {
            this.addToHead(p.info);
            p = p.next;
        }
        Node q = list2.head;
        while (q != null) {
            this.addToHead(q.info);
            q = q.next;
        }
        this.sort();
    }
    
    void addBefore(Node p, int x) {
        if (isEmpty()) {
            return;
        }
        Node q = head;
        if (q.info==p.info) {
            this.addToHead(x);
        } else {
            while (q.next != null) {
                if (q.next.info == p.info) {
                    this.addAfter(q, x);
                    break;
                }
                q = q.next;
            }
        }
    }

    void attach(MyList list1) {
        Node p = list1.head;
        while (p != null) {
            this.addToTail(p.info);
            p = p.next;
        }
        
    }
    
    void insert(int x) {
        Node p = head;
        while (p != null) {
            if (p.info >= x) {
                this.addBefore(p, x);
                break;
            }
            p = p.next;
        }
    }

    MyList reverse() {
        MyList my = new MyList();
        Node p = head;
        while (p != null) {
            my.addToHead(p.info);
            p = p.next;
        }
        return my;
    }

    boolean CheckSameContent(MyList list1, MyList list2) {
        Node p = list1.head, k = list2.head;
        if (list1.count()!=list2.count()) {
            return false;
        } else {
            while (p != null) {
            if (p.info!=k.info) {
                return false;
            }
            p = p.next;
            k=k.next;
        }
        return true;
        }
    }
    
}
