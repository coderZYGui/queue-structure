package com.zy;

/**
 * Description: 循环双端队列
 *
 * @author zygui
 * @date 2020/4/14 08:07
 */
public class CircleDeque<E> {
    // 存储队头(首元素)元素的下标
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
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

    // 从队尾入队
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size++;
    }

    // 从队头出队
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    // 从队头入队
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);

        front = index(-1); // 存放真实索引
        elements[front] = element;
        size++;
    }

    // 从队尾出队
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }


    // 获取队列的头元素
    public E front() {
        return elements[front];
    }

    // 获取队列的尾元素
    public E rear() {
        // 队头下标+size-1就是队尾下标
        // return elements[(front + size - 1) % elements.length];
        return elements[index(size - 1)];
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
        index += front;
        if (index < 0)
            return index + elements.length;
        return index % elements.length;
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
