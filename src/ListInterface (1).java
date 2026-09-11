import java.util.Iterator;

public interface ListInterface {

    /*
    essential operations
    */
    public boolean isEmpty();

    public int getSize();

    public void clear();

    public Object getHead();

    public Object getTail();

    public Object get(DoubleNode node);

    public DoubleNode search(Object object);

    public boolean add(Object object);

    public boolean insert(DoubleNode node, Object object);

    public boolean insert(Object objectRef, Object object);

    public boolean insertHead(Object object);

    public boolean insertTail(Object object);

    public boolean set(DoubleNode node, Object object);

    public boolean remove(DoubleNode node);

    /*
    expansion operations
     */
    public boolean contains(Object object);

    public Object[] toArray();

    public Object[] toArray(Object[] object);

    public MiListaDoble subList(DoubleNode from, DoubleNode to);

    public MiListaDoble sortList();

}
