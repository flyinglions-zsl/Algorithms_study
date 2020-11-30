package study.链表;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

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
        return add(size,obj);
    }

    /**
     *  指定下标添加元素
     * */
    public boolean add(int index, Object obj){
        validateRange(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = obj;
        size++;

        return true;
    }


    /**
     *  删除下标对应的元素
     * */
    public E remove(int index){
        validateRange(index);
        E old = (E) elementData[index];
        for (int i = index + 1; i < size; i++) {
            elementData[i - 1] = elementData[i];
        }
        elementData[--size] = null;
        return old;
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

    private void ensureCapacity(int capacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        Object []newElemnts = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElemnts[i] = elementData[i];
        }
        elementData = newElemnts;

    }


    private String getOutMsg(int index){
        return "out index is:" + index + ", size is:" + size;
    }

    private void validateRange(int index){
        if (index >= size)
            throw new IndexOutOfBoundsException(getOutMsg(index));
    }


    public static void main(String[] args) {
        // 两个线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //jdk1.8之前的实现方式
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("task started!");
                try {
                    //模拟耗时操作
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "task finished!";
            }
        }, executor);

        //采用lambada的实现方式
        future.thenAccept(e -> System.out.println(e + " ok"));

        System.out.println("main thread is running");

    }
}
