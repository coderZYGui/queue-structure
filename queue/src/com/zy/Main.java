package com.zy;

/**
 * Description: 测试类
 *
 * @author zygui
 * @date 2020/4/11 21:07
 */
public class Main {
    public static void main(String[] args) {

        CircleQueue<Integer> queue = new CircleQueue<>();

        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i); // 入队
        }
        System.out.println(queue);

        // null, null, null, null, null, 5, 6, 7, 8, 9
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }
        System.out.println(queue);

        // 15, 16, 17, 18, 19, 5, 6, 7, 8, 9
        for (int i = 15; i < 23; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.print(queue.deQueue() + " ");
        }

    }
}
