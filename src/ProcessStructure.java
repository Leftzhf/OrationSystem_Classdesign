import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class ProcessStructure {
    String pattern = "HH:mm";
    private String name;//进程名
    private Time arriveTime = new Time();//到达时间

    private Double serveTime ;//服务时间
    private Time beginTime = new Time();//开始时间
    private Time finshTime = new Time();//结束时间
    private Double roundTime;//周转时间
    private Double waitTime =0.0;//记录每个进程到达后的等待时间，只用于最高响应比优先调度算法中
    private Integer priority;//优先级
    private Double restTime = 0.0;//剩余时间
    private Double RR;
    private boolean visited = false;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Double getRestTime() {
        return restTime;
    }

    public void setRestTime(Double restTime) {
        this.restTime = restTime;
    }

    public Double getRR() {
        return RR;
    }

    public void setRR(Double RR) {
        this.RR = RR;
    }

    public ProcessStructure() {
    }

    public ProcessStructure(String name, Time  arriveTime,
                            Double serveTime, Time beginTime,
                            Time finshTime, Double roundTime, Double avgRoundTime, Double waitTime, Integer priority) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.beginTime = beginTime;
        this.finshTime = finshTime;
        this.roundTime = roundTime;
      //  this.avgRoundTime = avgRoundTime;
        this.waitTime = waitTime;
        this.priority = priority;
        this.restTime = this.serveTime;
    }

    public ProcessStructure(String name, Time  arriveTime,
                            Double serveTime, Time  beginTime,
                            Time  finshTime, Double roundTime, Double  waitTime) throws ParseException {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.beginTime = beginTime;
        this.finshTime = finshTime;
        this.roundTime = roundTime;
    //    this.avgRoundTime = avgRoundTime;
        this.waitTime = waitTime;
        this.restTime = this.serveTime;
    }


    @Override
    public String toString() {

        return
                ", name='" + name + '\'' +
                ", arriveTime=" + arriveTime +
                ", serveTime=" + serveTime +
                ", beginTime=" + beginTime +
                ", finshTime=" + finshTime +
                ", roundTime=" + roundTime +
                ", waitTime=" + waitTime +'\n';
    }

    public ProcessStructure(String name, Time  arriveTime,
                            Double serveTime) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.restTime = this.serveTime;
    }

    public ProcessStructure(String name, Time  arriveTime,
                            Double serveTime, Integer priority) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }


    public Time  getArriveTime() {
        return arriveTime;
    }


    public Double getServeTime() {
        return serveTime;
    }

    public void setServeTime(Double serveTime) {
        this.serveTime = serveTime;
    }

    public Time  getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time  beginTime) {
        this.beginTime = beginTime;
    }

    public Time  getFinshTime() {
        return finshTime;
    }

    public void setFinshTime(Time  finshTime) {
        this.finshTime = finshTime;
    }

    public Double getRoundTime() {
        return roundTime;
    }

    public void setRoundTime(Double roundTime) {
        this.roundTime = roundTime;
    }


    public Double  getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Double  waitTime) {
        this.waitTime = waitTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
