package com.zy;

/**
 * Description: 循环队列实现
 *
 * @author zygui
 * @date 2020/4/13 23:29
 */
public class CircleQueue<E> {

    // 存储队头(首元素)元素的下标
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // 元素的数量
    public int size() {
        return size;
    }

    // 队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 入队
    public void enQueue(E element) {
        ensureCapacity(size + 1);
        // 计算出入队的实际位置
        elements[index(size)] = element;
        size++;
    }

    // 出队
    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        //front++; // 需要计算front的位置,不然会指向最后不存在的位置
        front = index(1);
        size--;
        return frontElement;
    }

    // 获取队列的头元素
    public E front() {
        return elements[front];
    }

    /**
     * 保证要有capacity的容量
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;

        // 重置front
        front = 0;
    }

    /**
     * 将之前的索引转换到现在循环数组的真实索引
     *
     * @param index
     * @return
     */
    private int index(int index) {
        return (front + index) % elements.length;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity=").append(elements.length)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
