package com.lym.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyQueue
 * @Description 队列
 * @Author 李雁敏
 * @Date 2020/3/28 11:25
 * @Version 1.0
 */
public class MyQueue {
    //创建一个List数组
    private List<Integer> data;
    //数组起始的位置
    private int p_start;

    /*
     * @author 李雁敏
     * @Description 调用构造函数对数组和起始位置进行初始化
     * @Date 2020/3/28 11:50
     * @Param []
     * @return
     **/
    private MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }

    /*
     * @author 李雁敏
     * @Description 向数组添加元素，添加成功返回true
     * @Date 2020/3/28 11:50
     * @Param [x]
     * @return boolean
     **/
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /*
     * @author 李雁敏
     * @Description 删除元素，删除成功返回true，先判断数组是否为空
     * 这里的元素是先进先出的，所以这里删除一个元素的话，那么数组的第一个元素就是下一个
     * @Date 2020/3/28 11:50
     * @Param []
     * @return boolean
     **/

    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        p_start++;
        return true;
    }

    /*
     * @author 李雁敏
     * @Description 获取到数组的第一个元素
     * @Date 2020/3/28 11:49
     * @Param []
     * @return int
     **/
    public int Front() {
        return data.get(p_start);
    }

    /*
     * @author 李雁敏
     * @Description 检查队列是否为空
     * @Date 2020/3/28 11:49
     * @Param []
     * @return boolean
     **/
    public boolean isEmpty() {
        return p_start >= data.size();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
    }
}
