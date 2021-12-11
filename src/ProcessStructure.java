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
    private Time waitTime = new Time();//记录每个进程到达后的等待时间，只用于最高响应比优先调度算法中
    private Integer priority;//优先级
    private Double RR;

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
                            Time finshTime, Double roundTime, Double avgRoundTime, Time waitTime, Integer priority) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.beginTime = beginTime;
        this.finshTime = finshTime;
        this.roundTime = roundTime;
      //  this.avgRoundTime = avgRoundTime;
        this.waitTime = waitTime;
        this.priority = priority;
    }

    public ProcessStructure(String name, Time  arriveTime,
                            Double serveTime, Time  beginTime,
                            Time  finshTime, Double roundTime, Time  waitTime) throws ParseException {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.beginTime = beginTime;
        this.finshTime = finshTime;
        this.roundTime = roundTime;
    //    this.avgRoundTime = avgRoundTime;
        this.waitTime = waitTime;
    }


    @Override
    public String toString() {
        return "ProcessStructure{" +
                "pattern='" + pattern + '\'' +
                ", name='" + name + '\'' +
                ", arriveTime=" + arriveTime +
                ", serveTime=" + serveTime +
                ", beginTime=" + beginTime +
                ", finshTime=" + finshTime +
                ", roundTime=" + roundTime +
                ", waitTime=" + waitTime +
                ", priority=" + priority +
                ", RR=" + RR +
                '}';
    }

    public ProcessStructure(String name, Time  arriveTime,
                            Double serveTime) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;

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

    public void setName(String name) {
        this.name = name;
    }

    public Time  getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time  arriveTime) {
        this.arriveTime = arriveTime;
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


    public Time  getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Time  waitTime) {
        this.waitTime = waitTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
