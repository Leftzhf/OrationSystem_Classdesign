
import java.util.LinkedList;
import java.util.Scanner;

public class test {
    static BasicUtil basicUtil = new BasicUtil();

    public static void main(String[] args) {
        System.out.println("请输入要执行的进程数：");
        Scanner scanner = new Scanner(System.in);
        int k  = scanner.nextInt();
        LinkedList<ProcessStructure> list = new LinkedList<>();
        for(int i=1;i<=k;i++)
        {
            list.add(basicUtil.init(i));
        }
        for (ProcessStructure processStructure : list) {
            System.out.println(processStructure);
        }

    }
}
