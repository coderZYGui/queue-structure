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
        // 计算出入队的实际位置
        elements[(front + size) % elements.length] = element;
        size++;
    }

    // 出队
    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        //front++; // 需要计算front的位置,不然会指向最后不存在的位置
        front = (front + 1) % elements.length;
        size--;
        return frontElement;
    }

    // 获取队列的头元素
    public E front() {
        return elements[front];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity=").append(elements.length).append(" size=").append(size).append(", [");
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
