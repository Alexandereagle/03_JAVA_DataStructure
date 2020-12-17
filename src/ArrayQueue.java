import javax.management.RuntimeErrorException;
import java.util.Scanner;

public class ArrayQueue {
    int maxSize;
    int front;
    int rear;
    int[] queue;

    // 初始化队列,
    ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.queue = new int[maxSize];
    }

    // 判断队列是否已满
    public boolean queueIsFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean queueIsEmpty() {
        return front == rear;
    }

    // 队列加入数据
    public void queueAddData(int data) {
        if (this.queueIsFull()) {
            throw new RuntimeException("队列已满, 无法加入队列");
        }
        this.queue[++rear] = data;
    }

    // 队列删除数据
    public int queueDeleteData() {
        if (this.queueIsEmpty()) {
            throw new RuntimeException("队列已空, 无法返回数据");
        }
        return queue[++front];
    }

    // 获取队列的第一个数据
    public int queueGetHead() {
        if (this.queueIsEmpty()) {
            throw new RuntimeException("队列已空，无法返回数据");
        }
        return queue[front + 1];
    }

    // 显示队列的所有数据
    public void queuePrintAll() {
        int left = this.front;
        int right = this.rear;

        while (++left <= right) {
            System.out.print(queue[left]);
            System.out.println(", ");
        }
        System.out.println();
    }
}

class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("----------菜单-----------");
            System.out.println("输入f为判断队列是否已满");
            System.out.println("输入e为判断队列是否为空");
            System.out.println("输入a为队列添加元素");
            System.out.println("输入d为删除队列的第一个元素");
            System.out.println("输入h为获取队列的首元素");
            System.out.println("输入p为打印队列的所有数据");

            System.out.println("--------------------------");

            System.out.print("请输入一个字符: ");
            char c = scanner.next().charAt(0);
            switch (c) {
                case 'f':
                    arrayQueue.queueIsFull();
                    break;
                case 'e':
                    arrayQueue.queueIsEmpty();
                    break;
                case 'a':
                    System.out.print("请输入一个数字: ");
                    int inputData = scanner.nextInt();
                    try {
                        arrayQueue.queueAddData(inputData);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;
                case 'd':
                    try {
                        int deleteData = arrayQueue.queueDeleteData();
                        System.out.println(deleteData);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'h':
                    try {
                        int headData = arrayQueue.queueGetHead();
                        System.out.println(headData);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'p':
                    arrayQueue.queuePrintAll();
                    break;
                default:
                    System.out.println("输入错误字符");
                    break;
            }
        }

    }
}
