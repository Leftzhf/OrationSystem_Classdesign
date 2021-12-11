public class Time {

    private Double hour = 0.0;
    private Double minute = 0.0;

    /**
     * 计算两个时间差值（单位分钟）
     * @param a
     * @param b
     * @return a-b
     */
    public static Double minusTime(Time a,Time b)
    {
        Double time = a.getTime();
        Double time1 = b.getTime();
        return Math.abs(time1 - time);
    }

    /**
     * 加x分钟
     * @param minute
     */
    public void addMinute(double minute)
    {
        if(minute>=60)
        {
            this.hour+=(int)(minute/60);
            this.minute += minute%60;
        }
        else this.minute+=minute;

        if(this.minute>=60)
        {
            this.minute = 0.0;
            this.hour+=1;
        }
    }

    /**
     * 加x小时
     * @param hour
     */
    public void addHour(double hour)
    {
        this.hour+=hour;
    }

    /**
     * 减x小时
     * @param hour
     */
    public void minusHour(double hour)
    {
        this.hour -= hour;
    }

    /**
     * 减x分钟
     * @param minute
     */
    public void minusMinute(double minute)
    {
        if((this.minute - minute)<0)
        {
            while (minute>this.minute)
            {
                minute = minute - this.minute;
                this.minute = 60.0;
                this.hour -=1.0;
            }
            this.minute -= minute;

        }
        else this.minute-=minute;
    }

    @Override
    public String toString() {
        return this.hour.intValue()+":"+this.minute.intValue();
    }
    public Double getTime()
    {
        return hour*60+minute;
    }
    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Double getMinute() {
        return minute;
    }

    public void setMinute(Double minute) {
        if(minute>=60)
        {
            this.hour+=(int)(minute/60);
            this.minute += minute%60;
        }
       else  this.minute = minute;
    }

    public Time() {
    }

    public Time(Double hour, Double minute) {
        this.hour = hour;
        this.minute = minute;
    }

}
