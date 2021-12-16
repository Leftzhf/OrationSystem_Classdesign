import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Alg implements Dispatch{
    LinkedList<ProcessStructure> res = new LinkedList<>();
    BasicUtil basicUtil = new BasicUtil();
    @Override
    public LinkedList<ProcessStructure> FcFs(LinkedList<ProcessStructure> queue, String currentTime) {
        Time current = basicUtil.formatTime(currentTime);
        return res;
    }

    @Override
    public LinkedList<ProcessStructure> SjF(LinkedList<ProcessStructure> queue, String currentTime) {
        Time current = basicUtil.formatTime(currentTime);
        return res;
    }

    @Override
    public LinkedList<ProcessStructure> HrrN(LinkedList<ProcessStructure> queue, String currentTime) {
        Time current = basicUtil.formatTime(currentTime);
        return res;
    }

    @Override
    public LinkedList<ProcessStructure> HpF(LinkedList<ProcessStructure> queue, String currentTime) {
        Time current = basicUtil.formatTime(currentTime);
        return res;
    }

    @Override
    public LinkedList<ProcessStructure> SRTF(LinkedList<ProcessStructure> queue, String currentTime) {
        boolean flag = false;
        int count = queue.size();
        Time current = basicUtil.formatTime(currentTime);
        LinkedList<ProcessStructure> ready = new LinkedList<>();
        ProcessStructure running = null;
        current = queue.peek().getArriveTime();
        while(count!=0)
        {
            ProcessStructure peek = queue.peek();
            if(!queue.isEmpty() && basicUtil.ifGreaterEqual(current,peek.getArriveTime()))
            {

                ready.add(peek);
                //找到当前就绪队列中剩余时间最短的进程
                ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (o1.getRestTime() - o2.getRestTime()));
                //在下一次判断到达前该进程可以放心执行
                running = min;
                if(!running.isVisited())
                {
                    min.setBeginTime(current);
                    running.setVisited(true);
                }
                queue.remove(peek);
            }
            else if(queue.isEmpty())
            {
                ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (o1.getRestTime() - o2.getRestTime()));
                running = min;
                if(!running.isVisited())
                {
                    min.setBeginTime(current);
                    running.setVisited(true);
                }
            }

            if(running!=null)
            {       //下一次需要判断的时刻
                Time next;
                if(!queue.isEmpty())
                {

                    next = queue.peek().getArriveTime();
                }
                else {

                    Double restTime = running.getRestTime();
                    int restHour = (int) (restTime/60);
                    Double restMinute = restTime%60;
                    next = basicUtil.addTime(new Time((double)restHour, restMinute),current);
                //    next = new Time(restHour, restMinute);
                }
                //距离下一次判断还需要多长时间（分钟）
                Double  RunningTime = basicUtil.minusTime(current, next);

                //获得当前正在运行进程的剩余运行时间
                Double restTime = running.getRestTime();
                //当前进程在下一次判断时，是否能完成？
                double leftTime = restTime - RunningTime;
                //如果到下次需要判断时，当前运行进程已经运行完，就从ready队列移除,同时改变running
                if(leftTime <=0 )
                {
                    ready.remove(running);
                    running.setFinshTime(basicUtil.addMinute(current,restTime));
                    count--;
                    running.setRestTime(0.0);
                    res.add(running);
                    if(count==0)return res;
                    //如果lefttime小于0，那么此时running_time还没有用完可以让其他的read队列中的剩余时间最短的进程接着运行
                    double absLeftTime = Math.abs(leftTime);
                    while(!ready.isEmpty() && absLeftTime>0)
                    {
                        //找到当前就绪队列中剩余时间最短的进程
                        ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (o1.getRestTime() - o2.getRestTime()));
                        //在下一次判断到达前该进程可以放心执行
                        running = min;
                        Double restTime_next = running.getRestTime();

                        if(restTime_next  > absLeftTime)
                        {

                            running.setRestTime(restTime_next-absLeftTime);
                            absLeftTime = 0;
                        }
                        //当前进程执行结束
                        else
                        {
                            ready.remove(running);
                            running.setFinshTime(basicUtil.addMinute(current,restTime_next+restTime));
                            running.setRestTime(0.0);
                            res.add(running);
                            current = running.getFinshTime();
                            flag = true;
                            absLeftTime -= restTime_next;
                            count--;
                            if(count==0)return res;
                        }
                    }
                }
                else running.setRestTime(running.getServeTime()-RunningTime);
                //current到达下一个可运行时间段
                if(flag)
                {
                    flag = false;
                    continue;
                }

                current = basicUtil.addMinute(current,RunningTime);
//                Time prev = new Time(current.getHour(),current.getMinute());
//
//                if(basicUtil.ifGreaterEqual(prev,current))
//                {
//                    current = prev;
//                }
            }



        }
        return  res;
    }
}
