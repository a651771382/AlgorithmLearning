package com.lym.queue;

/**
 * @ClassName MyCircularQueue
 * @Description 循环队列
 * @Author 李雁敏
 * @Date 2020/3/28 11:48
 * @Version 1.0
 */
public class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    /*
     * @author 李雁敏
     * @Description 使用类构造函数对类属性进行初始化赋值
     * @Date 2020/3/28 13:54
     * @Param [k]
     * @return
     **/
    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /*
     * @author 李雁敏
     * @Description 将元素插入循环数组，如果操作成功，返回true
     * @Date 2020/3/28 13:59
     * @Param [value]
     * @return boolean
     **/
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /*
     * @author 李雁敏
     * @Description 删除循环元素，如果删除成功，返回true
     * @Date 2020/3/28 14:05
     * @Param []
     * @return boolean
     **/
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /*
     * @author 李雁敏
     * @Description 获取循环数组中最起始位置的元素
     * @Date 2020/3/28 14:08
     * @Param []
     * @return int
     **/
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }

    /*
     * @author 李雁敏
     * @Description 从循环数组中获取最后一个元素
     * @Date 2020/3/28 16:26
     * @Param []
     * @return int
     **/
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }

    /*
     * @author 李雁敏
     * @Description 检查循环队列是否为空
     * @Date 2020/3/28 16:27
     * @Param []
     * @return boolean
     **/
    public boolean isEmpty() {
        return head == -1;
    }

    /*
     * @author 李雁敏
     * @Description 检查循环队列是否已满
     * 这里把循环队列当做一个园，做了size+1的切分，在本程序中由于起始下标尾-1，那么就是分为了size份
     * 那么这里用((tail + 1) % size) == head公式计算，如果是true的话，那么我们的循环列表就是满了
     * @Date 2020/3/28 16:28
     * @Param []
     * @return boolean
     **/
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}
