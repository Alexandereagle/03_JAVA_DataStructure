public class DoubleLinked {
    public DoubleLinkedData header;

    public DoubleLinked() {
        header = new DoubleLinkedData();
        header.no = -1;
        header.name = "";
        header.nickname = "";
    }

    // 链表的遍历
    public void LinkedPrint() {
        DoubleLinkedData temp = header;
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
    public void LinkedAdd(DoubleLinkedData linkedDataAdd) {
        DoubleLinkedData temp = header;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = linkedDataAdd;
        linkedDataAdd.per = temp;
    }

    // 链表的有序增加
    public void LinkedAddSort(DoubleLinkedData linkedDataAdd) {
        DoubleLinkedData temp = header;
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
        linkedDataAdd.per = temp;
    }

    // 链表的删除
    public void LinkedDel(int number) {
        DoubleLinkedData temp = header;
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
            DoubleLinkedData cur = temp.next;
            temp.next.per = temp.per;
            temp.per.next = temp.next;
        } else {
            System.out.println("无此节点,无法删除");
        }
    }

    // 链表的改
    public void LinkedUpdate(DoubleLinkedData linkedDataUpdate) {
        DoubleLinkedData temp = header.next;
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
        DoubleLinkedData temp = header.next;
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


}

class DoubleLinkedData {
    public int no;
    public String name;
    public String nickname;

    public DoubleLinkedData next;
    public DoubleLinkedData per;

    public DoubleLinkedData(int number, String name, String nickname) {
        this.no = number;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DoubleLinkedData{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public DoubleLinkedData() {

    }
}

class DoubleLinkedTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        DoubleLinked linked = new DoubleLinked();
        DoubleLinkedData first = new DoubleLinkedData(1, "宋江", "及时雨");
        DoubleLinkedData second = new DoubleLinkedData(2, "吴用", "智多星");
        DoubleLinkedData third = new DoubleLinkedData(3, "林冲", "豹子头");
        linked.LinkedAdd(first);
        linked.LinkedAdd(second);
        linked.LinkedAdd(third);

        linked.LinkedDel(4);
        linked.LinkedFind(2);
        linked.LinkedUpdate(new DoubleLinkedData(2, "孙悟空", "美猴王"));

        linked.LinkedAddSort(new DoubleLinkedData(0, "如来", "我佛慈悲"));
        linked.LinkedAddSort(new DoubleLinkedData(5, "法海", "大威天龙  师尊地藏"));
        linked.LinkedAddSort(new DoubleLinkedData(6, "观音菩萨", "般若巴嘛空"));
        linked.LinkedPrint();
        long l = System.currentTimeMillis();
        System.out.println(l - start);
        System.out.println(l);
    }
}
