import java.util.ArrayList;

/**
 * 自定义实现动态数组
 * */
public class MyArrayList<E> {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 存储元素的容器
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * The size of the ArrayList (the number of elements it contains).
     *
     * @serial
     */
    private int size;

    /**
     * The maximum size of array to allocate.
     * */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     *获取元素的数量
     * */
    public int size(){
        return size;
    }

    /**
     * 判断数组是否为空
     * */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     *  是否包含某个元素-即存在下标
     * */
    public boolean contains(Object obj){
        return indexOf(obj) >= 0;
    }

    /**
     *  返回下标对应的元素
     * */
    public E get(int index){
        //检查下标
        validateRange(index);
        return (E) elementData[index];
    }

    /**
     *  设置下标对应的元素
     * */
    public boolean set(int index, Object obj){
        validateRange(index);
        elementData[index] = obj;
        size++;
        return true;
    }

    /**
     * 添加元素到最后位
     * */
    public boolean add(Object obj){
        elementData[size++] = obj;
        return true;
    }

    /**
     *  指定下标添加元素
     * */
    public boolean add(int index, Object obj){
        validateRange(index);
        elementData[index] = obj;
        size++;
        return true;
    }


    /**
     *  删除下标对应的元素
     * */
    public boolean remove(int index){
        validateRange(index);
        elementData[index] = null;
        size--;
        return true;
    }

    /**
     *  返回元素的下标位置,没有元素返回-1即可
     * */
    public int indexOf(Object obj){
        if (obj == null){
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (obj.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    /**
     *  清除所有元素
     * */
    public void clear(){
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
    }

    /**
     *  遍历所有元素
     * */
    public boolean iterator(Object obj){
        elementData[size++] = obj;
        return true;
    }

    private String getOutMsg(int index){
        return "out index is:" + index + ", size is:" + size;
    }

    private void validateRange(int index){
        if (index >= size)
            throw new IndexOutOfBoundsException(getOutMsg(index));
    }


}
