import java.util.Scanner;

public class CircleArrayQueue {
    int maxSize;
    int front;
    int rear;
    int[] queue;

    // 队列初始化
    // 1、队首设置为 首元素
    // 2、队尾设置为 末尾元素的后一个元素
    CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.queue = new int[maxSize + 1];
    }

    // 判断队列是否已满, (rear + maxsize - front) % maxsize == 0
    public boolean queueIsFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空, 当
    public boolean queueIsEmpty() {
        return front == rear;
    }

    // 队列加入数据
    public void queueAddData(int data) {
        if (this.queueIsFull()) {
            throw new RuntimeException("队列已满, 无法加入队列");
        }

        this.queue[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    // 队列删除数据
    public int queueDeleteData() {
        if (this.queueIsEmpty()) {
            throw new RuntimeException("队列已空, 无法返回数据");
        }
        int temp = queue[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    // 获取队列的第一个数据
    public int queueGetHead() {
        if (this.queueIsEmpty()) {
            throw new RuntimeException("队列已空，无法返回数据");
        }
        return queue[front];
    }

    // 求出队列的有效元素个数
    public int queueValidData() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的所有数据
    public void queuePrintAll() {
        int validData = queueValidData();
        for (int i = front; i <= front + validData - 1; i++) {
            System.out.print(queue[i % maxSize] + ", ");
        }
        System.out.println();
    }
}

class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----------菜单-----------");
            System.out.println("输入f为判断队列是否已满");
            System.out.println("输入e为判断队列是否为空");
            System.out.println("输入a为队列添加元素");
            System.out.println("输入d为删除队列的第一个元素");
            System.out.println("输入h为获取队列的首元素");
            System.out.println("输入p为打印队列的所有数据");
            System.out.println("输入t为退出程序");
            System.out.println("--------------------------");

            System.out.print("请输入一个字符: ");
            char c = scanner.next().charAt(0);
            switch (c) {
                case 'f':
                    circleArrayQueue.queueIsFull();
                    break;
                case 'e':
                    circleArrayQueue.queueIsEmpty();
                    break;
                case 'a':
                    System.out.print("请输入一个数字: ");
                    int inputData = scanner.nextInt();
                    try {
                        circleArrayQueue.queueAddData(inputData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'd':
                    try {
                        int deleteData = circleArrayQueue.queueDeleteData();
                        System.out.println(deleteData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headData = circleArrayQueue.queueGetHead();
                        System.out.println(headData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    circleArrayQueue.queuePrintAll();
                    break;
                case 't':
                    scanner.close();
                    return;
                default:
                    System.out.println("输入错误字符");
                    break;
            }
        }

    }
}
