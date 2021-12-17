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
        boolean flag = false;
        int count = queue.size();//后备队列目前的长度,有多少个进程就要执行多少次判断
        Time current = basicUtil.formatTime(currentTime);
        LinkedList<ProcessStructure> ready = new LinkedList<>();//初始化就绪队列
        ProcessStructure running = null;//CPU正在处理的进程
        current = queue.peek().getArriveTime();//初始化当前时间设置为当前后备作业的队头的到达时间

        ProcessStructure peek= queue.peek();//初始化队头
        ready.add(peek);
        queue.remove(peek);
        while(count!=0)//调度算法
        {
            peek = queue.peek();//获取后备队列中的队头进程
            //如果有进程到达了，就加入就绪队列
            if (!queue.isEmpty() )//如果后备队列非空且当前时间大于进程到达时间（进程已经到达）
            {
                //找到当前就绪队列中剩余时间最短的进程
                ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (o1.getServeTime() - o2.getServeTime()));
                //在下一次判断到达前该进程可以放心执行（下一次判断是下一个进程到达的时候或者是当前进程结束的时候）
                running = min;//设置为运行态
                min.setBeginTime(current);
                running.setVisited(true);//置访问标志位
                current=basicUtil.addMinute(current,min.getServeTime());
                min.setFinshTime(current);
                res.add(min);
                ready.remove(running);//当前进程执行结束，让出cpu
                while(basicUtil.ifGreaterEqual(current, queue.peek().getArriveTime()))//把此时已经到达的进程都加入就绪队列以便下一次判断
                {
                    ready.add(queue.peek());//后备队列队头作业进程对换进入就绪队列
                    queue.remove(queue.peek());//后备队列队头出队
                    if(queue.peek()==null)
                        break;
                }
                if (ready.size()==0)//如果此时就绪队列为空（下一个进程在当前时间之后到达）则从后备队列中加入进程并设置当前时间为到达时间
                {
                    peek = queue.peek();
                    ready.add(peek);
                    peek.setVisited(true);//置访问标志位
                    current=peek.getArriveTime();
                    queue.remove(peek);
                }

            } else if (queue.isEmpty())//如果目前后备队列为空（还没有作业到达）,就先选择就绪队列中的最短剩余时间进程执行,但是不从后备队列中加入
            {
                //找到当前就绪队列中剩余时间最短的进程
                ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (o1.getServeTime() - o2.getServeTime()));
                //在下一次判断到达前该进程可以放心执行（下一次判断是下一个进程到达的时候或者是当前进程结束的时候）
                running = min;//设置为运行态
                min.setBeginTime(current);
                running.setVisited(true);//置访问标志位
                current=basicUtil.addMinute(current,min.getServeTime());
                min.setFinshTime(current);
                res.add(min);
                ready.remove(running);//当前进程执行结束，让出cpu
            }
            count--;
        }
        return res;
    }

    @Override
    public LinkedList<ProcessStructure> HrrN(LinkedList<ProcessStructure> queue, String currentTime) {
        Time current = basicUtil.formatTime(currentTime);
        boolean flag = false;
        int count = queue.size();//后备队列目前的长度,有多少个进程就要执行多少次判断
        LinkedList<ProcessStructure> ready = new LinkedList<>();//初始化就绪队列
        ProcessStructure running = null;//CPU正在处理的进程
        current = queue.peek().getArriveTime();//初始化当前时间设置为当前后备作业的队头的到达时间

        ProcessStructure peek= queue.peek();//初始化队头
        ready.add(peek);
        queue.remove(peek);
        while(count!=0)//调度算法
        {
            peek = queue.peek();//获取后备队列中的队头进程
            //如果有进程到达了，就加入就绪队列
            if (!queue.isEmpty() )//如果后备队列非空且当前时间大于进程到达时间（进程已经到达）
            {
                //找到当前就绪队列中剩余时间最短的进程
                ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (1+o1.getWaitTime()/o1.getServeTime())-(1+o2.getWaitTime()/o2.getServeTime()));
                //在下一次判断到达前该进程可以放心执行（下一次判断是下一个进程到达的时候或者是当前进程结束的时候）
                running = min;//设置为运行态
                min.setBeginTime(current);
                running.setVisited(true);//置访问标志位
                current=basicUtil.addMinute(current,min.getServeTime());
                min.setFinshTime(current);
                res.add(min);
                ready.remove(running);//当前进程执行结束，让出cpu
                while(basicUtil.ifGreaterEqual(current, queue.peek().getArriveTime()))//把此时已经到达的进程都加入就绪队列以便下一次判断
                {
                    ready.add(queue.peek());//后备队列队头作业进程对换进入就绪队列
                    queue.remove(queue.peek());//后备队列队头出队
                    if(queue.peek()==null)
                        break;
                }
                if (ready.size()==0)//如果此时就绪队列为空（下一个进程在当前时间之后到达）则从后备队列中加入进程并设置当前时间为到达时间
                {
                    peek = queue.peek();
                    ready.add(peek);
                    peek.setVisited(true);//置访问标志位
                    current=peek.getArriveTime();
                    queue.remove(peek);
                }

            } else if (queue.isEmpty())//如果目前后备队列为空（还没有作业到达）,就先选择就绪队列中的最短剩余时间进程执行,但是不从后备队列中加入
            {
                //找到当前就绪队列中剩余时间最短的进程
                ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (o1.getServeTime() - o2.getServeTime()));
                //在下一次判断到达前该进程可以放心执行（下一次判断是下一个进程到达的时候或者是当前进程结束的时候）
                running = min;//设置为运行态
                min.setBeginTime(current);
                running.setVisited(true);//置访问标志位
                current=basicUtil.addMinute(current,min.getServeTime());
                min.setFinshTime(current);
                res.add(min);
                ready.remove(running);//当前进程执行结束，让出cpu
            }
            count--;
        }
        return res;
    }
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
        int count = queue.size();//后备队列长度
        Time current = basicUtil.formatTime(currentTime);
        LinkedList<ProcessStructure> ready = new LinkedList<>();//初始化就绪队列
        ProcessStructure running = null;
        current = queue.peek().getArriveTime();
        while(count!=0)//调度算法
        {
            ProcessStructure peek = queue.peek();//获取后备队列中的队头进程
            if(!queue.isEmpty() && basicUtil.ifGreaterEqual(current,peek.getArriveTime()))//如果队列非空且当前时间大于进程到达时间（进程已经到达）
            {//根据最短剩余时间进行一次判断

                ready.add(peek);
                //找到当前就绪队列中剩余时间最短的进程
                ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (o1.getRestTime() - o2.getRestTime()));
                //在下一次判断到达前该进程可以放心执行
                running = min;
                if(!running.isVisited())//找到的最短剩余时间的进程并设置当前时间为开始执行时间
                {
                    min.setBeginTime(current);
                    running.setVisited(true);//置访问标志位
                }
                queue.remove(peek);//后备队列队头出队
            }
            else if(queue.isEmpty())//如果后备队列没有进程到达，就设置从就绪队列中选择最短剩余时间进程运行.
            {
                ProcessStructure min = Collections.min(ready, (o1, o2) -> (int) (o1.getRestTime() - o2.getRestTime()));
                running = min;
                if(!running.isVisited())
                {
                    min.setBeginTime(current);
                    running.setVisited(true);
                }
            }

            if(running!=null)//如果当前有进程在运行，反复执行判断是否应该抢占
            {       //下一次需要判断的时刻
                Time next;
                if(!queue.isEmpty())//先看看后备队列空不空，如果不空，就设置好下一次判断的时间（下一个队列到来的时间）
                {
                    next = queue.peek().getArriveTime();//后备队列中下一个进程的到达时间
                }
                else {//否则的话，就设置好下一次判断的时间为当前进程运行结束的时间。
                    Double restTime = running.getRestTime();
                    int restHour = (int) (restTime/60);
                    Double restMinute = restTime%60;
                    next = basicUtil.addTime(new Time((double)restHour, restMinute),current);
                //    next = new Time(restHour, restMinute);
                }
                //距离下一次判断还需要多长时间（分钟）
                Double  RunningTime = basicUtil.minusTime(current, next);//当前时间为目前进程到达的时间，计算Next的差值

                //获得当前正在运行进程的剩余运行时间
                Double restTime = running.getRestTime();
                //当前进程在下一次判断时，是否能完成？
                double leftTime = restTime - RunningTime;
                //如果到下次需要判断时，当前运行进程已经运行完，就从ready队列移除,同时改变running
                if(leftTime <=0 )//不能完成，判断抢占
                {
                    ready.remove(running);//移除就绪队列
                    running.setFinshTime(basicUtil.addMinute(current,restTime));
                    count--;
                    running.setRestTime(0.0);
                    res.add(running);
                    if(count==0)return res;
                    //如果lefttime小于0，那么此时running_time还没有用完可以让其他的read队列中的剩余时间最短的进程接着运行
                    double absLeftTime = Math.abs(leftTime);//取剩余时间的绝对值
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
                        else//可以完成不用判断抢占,移除当前的
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
                else running.setRestTime(running.getServeTime()-RunningTime);//可以完成，设置剩余时间
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
