
import java.util.Collections;
import java.util.Comparator;
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
        String s = "0:0";
        LinkedList<ProcessStructure> srtf = new Alg().SRTF(list, s);
        srtf.sort(new Comparator<ProcessStructure>() {
            @Override
            public int compare(ProcessStructure o1, ProcessStructure o2) {
                return (int) (o1.getArriveTime().getTime() - o2.getArriveTime().getTime());
            }
        });
        double avg = 0.0;
        double size= srtf.size();
        for (ProcessStructure structure : srtf) {
            structure.setRoundTime(structure.getFinshTime().getTime()-structure.getArriveTime().getTime());
            System.out.println(structure);
            avg+=structure.getRoundTime();
        }
        System.out.println("平均周转时间："+avg/size);
    }
}
