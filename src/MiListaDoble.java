public class MiListaDoble implements ListInterface {
    DoubleNode head;
    DoubleNode tail;
    int size;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object getHead() {
        return head == null ? null : head.dato;
    }

    @Override
    public Object getTail() {
        return tail == null ? null : tail.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    public DoubleNode search(Object object) {
        DoubleNode current = head;
        while (current != null) {
            if (object == null ? current.dato == null : object.equals(current.dato)) {
                return current;
            }
            current = current.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        DoubleNode newNode = new DoubleNode(object);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.siguiente = newNode;
            newNode.anterior = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        DoubleNode newNode = new DoubleNode(object);
        newNode.siguiente = node.siguiente;
        newNode.anterior = node;

        if (node.siguiente != null) {
            node.siguiente.anterior = newNode;
        } else {
            tail = newNode;
        }
        node.siguiente = newNode;
        size++;
        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode targetNode = search(objectRef);
        if (targetNode == null) {
            return false;
        }
        return insert(targetNode, object);
    }

    @Override
    public boolean insertHead(Object object) {
        DoubleNode newNode = new DoubleNode(object);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.siguiente = head;
            head.anterior = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        return add(object);
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || isEmpty()) {
            return false;
        }
        if (node == head) {
            head = head.siguiente;
            if (head != null) {
                head.anterior = null;
            } else {
                tail = null;
            }
        } else if (node == tail) {
            tail = tail.anterior;
            if (tail != null) {
                tail.siguiente = null;
            } else {
                head = null;
            }
        } else {
            node.anterior.siguiente = node.siguiente;
            node.siguiente.anterior = node.anterior;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        DoubleNode current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.dato;
            current = current.siguiente;
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a == null || a.length < size) {
            a = (Object[]) java.lang.reflect.Array.newInstance(
                    a == null ? Object[].class.getComponentType() : a.getClass().getComponentType(), size);
        }
        DoubleNode current = head;
        int index = 0;
        while (current != null) {
            a[index++] = current.dato;
            current = current.siguiente;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        MiListaDoble sub = new MiListaDoble();
        if (from == null || to == null) {
            return sub;
        }
        DoubleNode current = from;
        while (current != null) {
            sub.add(current.dato);
            if (current == to) {
                break;
            }
            current = current.siguiente;
        }
        return sub;
    }

    @Override
    public MiListaDoble sortList() {
        if (size <= 1) {
            return this;
        }

        boolean swapped;
        do {
            swapped = false;
            DoubleNode current = head;
            while (current != null && current.siguiente != null) {
                if (current.dato instanceof Comparable &&
                        ((Comparable) current.dato).compareTo(current.siguiente.dato) > 0) {
                    Object temp = current.dato;
                    current.dato = current.siguiente.dato;
                    current.siguiente.dato = temp;
                    swapped = true;
                }
                current = current.siguiente;
            }
        } while (swapped);

        return this;
    }
}