package l2;

import java.util.LinkedList;

public class MyLinkedList {
    Node first;
    Node last;
    int size = 0;

    MyLinkedList() {
        first = null;
        last=null;  //this.last=null da diyebilirsin
        size=0;
    }

    public static void main(String[] args) {
        MyLinkedList m1 = new MyLinkedList();
        MyLinkedList m2 = new MyLinkedList();
        m2.insertFirst(100);
        m2.insertLast(101);
        m2.insertLast(102);
        m1.insertLast(3);
        m1.insertLast(8);
        m1.insertLast(-1);
        m1.insertFirst(9);
        m1.insertLast(17);
        m1.insertFirst(6);
        System.out.println(m1.toString());
        //Node n1 = new Node(11);
        m1.insertAfter(m1.searchNode(8),11); //8in hangi node da olduğunu bilmeme gerek yok search yapıp ulaşıyorum
        System.out.println(m1.toString());
        m1.removeFirst();
        System.out.println(m1.toString());
        m1.removeLast();
        System.out.println(m1.toString());

        System.out.println(m2.first);
        System.out.println(m2.last);


    }

    public int getsum() {
        int sum=0;
        if (isEmpty()) {
            return sum;
        }
        Node tmp=first;
        while (tmp!=null) {
            sum+= tmp.data;
            tmp=tmp.next;
        }
        return sum;
    }

    void insertFirst(int v) {
        Node newNode= new Node(v);
        if (first==null || last==null) {
            first=newNode;
            last=newNode;
        } else {
            newNode.next=first;
            first=newNode;
        } size++; }


        void insertLast(int v) {
            Node newNode= new Node(v);
            if (first==null || last==null) {
                first=newNode;
                last=newNode;
            }else {
                last.next=newNode;       //newNode=last.next; yazamazsın ilk olarak last.next objesi bulunmuyor
                last=newNode;
            } size++ ;}


            void insertAfter(Node p, int v) { // p=previous
        Node newNode = new Node(v);
        if (p==null || size==0) {
            System.out.println("the given node cannot be null!");
        } if (p==last) { insertLast(v); return;} // return koyma sebebi kod devam etmesin diye ancak onun yerine else if koyamaz mıyız
        else
          newNode.next=p.next;
          p.next=newNode;
          size++;  }

          public boolean isEmpty() {
        return size==0;  // bu ifade size==0 ın true mu false mi olduğunu döndürür.
          }

          public String toString() {
        if (isEmpty()) {
            return "list is empty";
        }
        Node tmp=first;
        String str = "List with "+ size + " elements ";
        while (tmp!=null) {
            str+= tmp.data +"->";
            tmp=tmp.next;
        }return  str;
          }

          Node searchNode(int x) {
        Node tmp =first;
        while (tmp!=null) {
            if (tmp.data==x) {
                return tmp;
            }
            tmp=tmp.next;
        }
        return null;
          }

          public Node removeFirst() {           // can do void
        if (isEmpty()) {
            return null;
        }
        Node tmp= first;
        first=first.next;
        size--;
        return tmp; //silineni gösteriyor
          }

          // ????????????
          public Node removeLast() {
        if (isEmpty()) {
            return  null;
        }
        Node secondLast=first;
        while (secondLast.next.next!=null) {
            secondLast=secondLast.next;
        }
        Node lastNode= secondLast.next; //save last node
        secondLast.next= null;
        last=secondLast;
        size--;
        return last;
          }


}
