import java.util.Stack;

// 实现单方链表的增删改查
public class Linked {
    public LinkedData header;

    public Linked() {
        header = new LinkedData();
        header.no = -1;
        header.name = "";
        header.nickname = "";
    }

    // 链表的遍历
    public void LinkedPrint() {
        LinkedData temp = header;
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        if (header.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
    }

    // 链表的增加
    public void LinkedAdd(LinkedData linkedDataAdd) {
        LinkedData temp = header;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = linkedDataAdd;
    }

    // 链表的有序增加
    public void LinkedAddSort(LinkedData linkedDataAdd) {
        LinkedData temp = header;
        while (temp.next != null) {
            if (temp.next.no > linkedDataAdd.no) {
                break;
            } else if (temp.next.no == linkedDataAdd.no) {
                System.out.println("节点已经存在不能删除: " + temp.next);
                return;
            }
            temp = temp.next;
        }
        linkedDataAdd.next = temp.next;
        temp.next = linkedDataAdd;
    }

    // 链表的删除
    public void LinkedDel(int number) {
        LinkedData temp = header;
        if (header.next == null) {
            return;
        }
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.no == number) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            LinkedData cur = temp.next;
            temp.next = cur.next;
        } else {
            System.out.println("无此节点,无法删除");
        }
    }

    // 链表的改
    public void LinkedUpdate(LinkedData linkedDataUpdate) {
        LinkedData temp = header.next;
        boolean flag = false;
        if (header.next == null) {
            return;
        }
        while (temp != null) {
            if (temp.no == linkedDataUpdate.no) {
                temp.nickname = linkedDataUpdate.nickname;
                temp.name = linkedDataUpdate.name;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag)
            System.out.println("无此节点,无法更新");
        else
            System.out.println(temp);
    }

    // 链表的查
    public void LinkedFind(int no) {
        LinkedData temp = header.next;
        if (header.next == null) {
            return;
        }
        while (temp != null) {
            if (temp.no == no) {
                System.out.println(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有此节点");
    }

    // 链表的有效个数
    public int linkedValidCount() {
        LinkedData temp = header.next;
        int validCount = 0;
        while (temp != null) {
            validCount += 1;
            temp = temp.next;
        }
        return validCount;
    }

    // 链表的倒数第K个节点
    public void lastKNode(int k) {
        if (header.next == null) {
            System.out.println("链表为空");
            return;
        }
        if (linkedValidCount() < k) {
            System.out.println("K比链表的有效元素多");
            return;
        }
        LinkedData temp = header.next;
        LinkedData cur = header.next;
        k -= 1;
        while (k-- > 0 && cur.next != null) {
            cur = cur.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            temp = temp.next;
        }
        System.out.println(temp);
    }

    void reverseLinked() {
        LinkedData newHeader = new LinkedData();
        LinkedData cur = header.next;
        while (cur != null) {
            LinkedData curNext = cur.next;
            cur.next = newHeader.next;
            newHeader.next = cur;
            cur = curNext;
        }
        header = newHeader;
    }

    void printLinedReverse() {
        LinkedData temp = header.next;
        Stack<LinkedData> linkedDataStack = new Stack<>();
        while (temp != null) {
            linkedDataStack.push(temp);
            temp = temp.next;
        }
        while (linkedDataStack.size() > 0) {
            System.out.println(linkedDataStack.pop());
        }
    }

}

//链表的数据存储
class LinkedData {
    public int no;
    public String name;
    public String nickname;

    public LinkedData next;

    public LinkedData(int number, String name, String nickname) {
        this.no = number;
        this.name = name;
        this.nickname = nickname;
    }

    public LinkedData() {

    }

    @Override
    public String toString() {
        return "LinkedData{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

class LinkedTest {
    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.lastKNode(6);
        LinkedData first = new LinkedData(1, "宋江", "及时雨");
        LinkedData second = new LinkedData(2, "吴用", "智多星");
        LinkedData third = new LinkedData(3, "林冲", "豹子头");
        linked.LinkedAdd(first);
        linked.LinkedAdd(second);
        linked.LinkedAdd(third);

        linked.LinkedDel(4);
        linked.LinkedFind(2);
        linked.LinkedUpdate(new LinkedData(2, "孙悟空", "美猴王"));

        linked.LinkedAddSort(new LinkedData(0, "如来", "我佛慈悲"));
        linked.LinkedAddSort(new LinkedData(5, "法海", "大威天龙  师尊地藏"));
        linked.LinkedAddSort(new LinkedData(6, "观音菩萨", "般若巴嘛空"));
        linked.lastKNode(6);
        linked.reverseLinked();
        linked.LinkedPrint();
        linked.printLinedReverse();
    }
}
