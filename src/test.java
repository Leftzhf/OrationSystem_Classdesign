
import com.sun.codemodel.internal.JCase;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class test {
    static BasicUtil basicUtil = new BasicUtil();

    public static void main(String[] args) {

        System.out.println("1.抢占式最短剩余时间优先算法(SRTF)");
        System.out.println("2.短作业优先算法(SJF)");
        System.out.println("3.先来先服务算法(FCFS)");
        System.out.println("4.最高响应比优先算法(HRRF)");
        System.out.println("5.算法(SRTF)");
        System.out.println("请选择要执行的调度算法");
        Scanner scanner = new Scanner(System.in);
        int alg_mode = scanner.nextInt();

        System.out.println("请输入要执行的进程数：");

        int k  = scanner.nextInt();
        LinkedList<ProcessStructure> list = new LinkedList<>();
        for(int i=1;i<=k;i++)
        {
            list.add(basicUtil.init(i));//进程初始化PCB
        }
        String s = "0:0";

        list.sort(new Comparator<ProcessStructure>() {
            @Override
            public int compare(ProcessStructure o1, ProcessStructure o2) {
                return (int) (o1.getArriveTime().getTime() - o2.getArriveTime().getTime());
            }//根据到达时间排序队列
        });
        switch (alg_mode)
        {
            case 1:
            {
                LinkedList<ProcessStructure> srtf = new Alg().SRTF(list, s);//调用SRTF算法,进程加入后备队列

                double avg = 0.0;
                double size= srtf.size();
                for (ProcessStructure structure : srtf) {
                    structure.setRoundTime(structure.getFinshTime().getTime()-structure.getArriveTime().getTime());//计算周转时间
                    System.out.println(structure);//输出周转时间
                    avg+=structure.getRoundTime();//计算平均周转时间
                }
                System.out.println("平均周转时间："+avg/size);
                break;
            }
            case 2:
            {

                LinkedList<ProcessStructure> sjf = new Alg().SjF(list, s);//调用SRTF算法,进程加入后备队列
                double avg = 0.0;
                double size= sjf.size();
                for (ProcessStructure structure : sjf) {
                    structure.setRoundTime(structure.getFinshTime().getTime()-structure.getArriveTime().getTime());//计算周转时间
                    System.out.println(structure);//输出周转时间
                    avg+=structure.getRoundTime();//计算平均周转时间
                }
                System.out.println("平均周转时间："+avg/size);
                break;
            }
            case 3:
            {
                break;
            }
            case 4:
            {

                LinkedList<ProcessStructure> hrrn = new Alg().HrrN(list, s);//调用SRTF算法,进程加入后备队列
                double avg = 0.0;
                double size= hrrn.size();
                for (ProcessStructure structure : hrrn) {
                    structure.setRoundTime(structure.getFinshTime().getTime()-structure.getArriveTime().getTime());//计算周转时间
                    System.out.println(structure);//输出周转时间
                    avg+=structure.getRoundTime();//计算平均周转时间
                }
                System.out.println("平均周转时间："+avg/size);
                break;
            }


        }

    }
}
