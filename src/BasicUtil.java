import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class  BasicUtil {

    Scanner scanner = new Scanner(System.in);
    String pattern = "HH:mm";
    String ServerTimePattern = "mm";

    public  Time addTime(Time a,Time b) {
        double min = a.getMinute() + b.getMinute();
        double hour = a.getHour() + b.getHour();
        if(min>=60)
        {
            hour+=(int)(min/60);
            min = min%60;
        }
        return new Time(hour,min);
    }

    /**
     * 如果a>b返回true，否则返回false
     * @param a
     * @param b
     * @return
     */
    public  boolean ifGreaterEqual(Time a,Time b)
    {
        double v = a.getHour() - b.getHour();
        if(v<0)return false;
        if(v==0) {
            double v1 = a.getMinute() - b.getMinute();
            return !(v1 < 0);
        }
        return true;
    }
    /**
     * 计算两个时间差值（单位分钟）
     * @param a
     * @param b
     * @return a-b
     */
    public  Double minusTime(Time a,Time b)
    {
        Double time = a.getTime();
        Double time1 = b.getTime();
        return Math.abs(time1 - time);
    }

    /**
     * 加x分钟
     * @param minute
     */
    public  Time addMinute(Time time,double minute)
    {     Double hour = time.getHour();
        Double minute1 = time.getMinute();
        if(minute>=60)
        {

            hour+=(int)(minute/60);
            minute1 += minute%60;
        }
        else minute1+=minute;

        if(minute1>=60)
        {
            minute1 = minute1-60.0;
            hour+=1;
        }
        return new Time(hour,minute1);
    }
    public Time formatTime(String s)
    {
        String[] split = s.split(":");
        return new Time(Double.valueOf(split[0]), Double.valueOf(split[1]));
    }
    public ProcessStructure init(int i)
    {

        System.out.println("输入第"+i+"个进程名字：");
        String name = scanner.next();
        System.out.println("输入该进程的到达时间：");
        String arriveTime = scanner.next();
        System.out.println("输入该进程的服务时间：");
        Double ServerTime = scanner.nextDouble();
        System.out.println("输入该进程的优先级，如果不需要优先级，则写-1");
        int priority = scanner.nextInt();

        Time arriveTimeInstance = formatTime(arriveTime);
        if(priority==-1)
        {
            return new ProcessStructure(name, arriveTimeInstance, ServerTime);
        }
        return new ProcessStructure(name, arriveTimeInstance, ServerTime,priority);
    }
}
