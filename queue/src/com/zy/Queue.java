package com.zy;

import com.zy.list.DoubleLinkedList;
import com.zy.list.List;

/**
 * Description: 队列的实现(根据双向链表实现)
 *
 * @author zygui
 * @date 2020/4/11 21:08
 */
public class Queue<E> {

    private List<E> list = new DoubleLinkedList<>();

    // 元素的数量
    public int size() {
        return list.size();
    }

    // 队列是否为空
    public boolean isEmpty() {
        return list.inEmpty();
    }

    // 入队
    public void enQueue(E element) {
        list.add(element);
    }

    // 出队
    public E deQueue() {
        return list.remove(0);
    }

    // 获取队列的头元素
    public E front() {
        return list.get(0);
    }

    // 清空队列
    public void clear() {
        list.clear();
    }
}
