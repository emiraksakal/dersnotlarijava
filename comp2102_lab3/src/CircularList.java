
public class CircularList {
    public DNode current;
    int size = 0;

    public CircularList(){
        current = null;
    }


    public void insertAfterCurrent(String s){
        DNode dn = new DNode(s);
        if(current==null){
            current = dn;
            current.next= current;
            current.previous = current;
        }
        else{
            dn.previous = current;
            dn.next = current.next;
            current.next.previous = dn;
            current.next=dn;
        }
        size++;
    }

    public void rotate(){
        current = current.next;
    }

    public void insertBeforeCurrent(String s){
        DNode dn = new DNode(s);
        if(current==null){
            current = dn;
            current.next= current;
            current.previous = current;
        }
        else{
            dn.previous = current.previous;
            current.previous.next =dn;
            dn.next = current;
            current.previous = dn;
        }
        size++;
    }
    public String toString(){
        DNode tmp = current;
        String s= "";
        while (tmp != current.previous){
            s+=tmp.data+"->";
            tmp = tmp.next;
        }
        s+=tmp.data;

        return s;
    }


    class DNode{
        public String data;
        public DNode next;
        public DNode previous;
        public DNode(String data){
            this.data = data;
            next = null;
            previous= null;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CircularList c1 = new CircularList();
        c1.insertAfterCurrent("sile");
        c1.insertAfterCurrent("agva");
        c1.insertBeforeCurrent("omerli");
        c1.insertBeforeCurrent("uskudar");
        System.out.println(c1);

        System.out.println(c1.current.data);
        c1.rotate();
        System.out.println(c1.current.data);
        c1.rotate();
        System.out.println(c1.current.data);
        c1.rotate();
        c1.rotate();
        System.out.println(c1.current.data);

    }


}
