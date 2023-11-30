
package EDD;

/**
 *
 * @author Luriannys Junco
 */
public class Cola {
    
    private Document head;
    private Document tail;
    private int size;

    /**
     * Constructor
     */
    public Cola() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    /**
     * Para saber si esta vacia
     * @return 
     */
    public boolean isEmpty(){
        return getHead() == null;
    }
    
    /**
     * Para vaciar la cola
     */
    public void empty(){
        this.setHead(this.tail = null);
        this.setSize(0);
    }
    
    /**
     * Para desencolar
     */
    public void dequeue(){
        if (this.isEmpty()){
            System.out.println("La cola esta vacia");
        } else if (getSize() == 1){
            this.empty();
        } else {
            Document elim=getHead();
            setHead(getHead().getpNext());
            setSize(getSize() - 1);
            elim.setpNext(null);
        }
    }
    /**
     * Para encolar
     * @param nuevo 
     */
    public void queue(Document nuevo){
        if (this.isEmpty()){
            setHead(nuevo);
            
        } else {
            getTail().setpNext(nuevo);
            
        }
        setTail(nuevo);
        setSize(getSize() + 1);
    }
    
    public Document getDoc(){
        if(this.isEmpty()) {
            return null;
        }else{
            return getHead();
        }
        
        
    }
    
    /**
     * Para imprimir la cola
     * @return printQueue
     */
    public String print(){
        if (!this.isEmpty()){
            String printQueue = "";
            for (int i = 0; i < getSize(); i++){
                Document actual = getHead();
                dequeue();
                printQueue += actual.getName()+ ",";
                queue(actual);
            }
            return printQueue;
        }
        return null;
    }

    /**
     * @return the head
     */
    public Document getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Document head) {
        this.head = head;
    }

    /**
     * @return the tail
     */
    public Document getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(Document tail) {
        this.tail = tail;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
}
