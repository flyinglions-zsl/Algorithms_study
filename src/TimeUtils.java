import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计算方法运行时间工具类
 * */
public class TimeUtils {

    private static final SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task{
        void execute();
    }
    public static void getRunningTime(String methodName, Task task){
        if (task == null) return;
        methodName = (methodName == null)? "":("["+methodName+"]");
        System.out.println(methodName);
        System.out.println("开始"  + formater.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束"  + formater.format(new Date()));
        double thetime = (end - begin)/1000.0;
        System.out.println("耗时：" + thetime + "秒");
    }
}
