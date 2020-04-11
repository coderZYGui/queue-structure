package com.zy;

/**
 * Description:
 *
 * @author zygui
 * @date 2020/4/11 21:07
 */
public class Main {
    public static void main(String[] args) {
//        Queue<Integer> queue = new Queue<>();
//        queue.enQueue(11);
//        queue.enQueue(22);
//        queue.enQueue(33);
//        queue.enQueue(44);

//        while (!queue.isEmpty()) {
//            System.out.println(queue.deQueue());
//        }

        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(11); // 从队头入队
        deque.enQueueFront(22);
        deque.enQueueRear(33); // 从队尾入队
        deque.enQueueRear(44);

        /* 44 33 11 22 */

        while (!deque.isEmpty()) {
            // 如果双端队列不为空,则从队头出队
            //System.out.println(deque.deQueueFront()); // 22, 11, 33, 44
            // 如果双端队列不为空,则从队尾出队
            System.out.println(deque.deQueueRear());  // 44, 33, 11, 22
        }
    }
}
