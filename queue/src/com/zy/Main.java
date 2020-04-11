package com.zy;

/**
 * Description:
 *
 * @author zygui
 * @date 2020/4/11 21:07
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
