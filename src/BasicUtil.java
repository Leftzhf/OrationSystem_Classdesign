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
