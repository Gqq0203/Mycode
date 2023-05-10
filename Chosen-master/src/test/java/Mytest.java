import com.wzx.Dao.RegisterMapper;
import com.wzx.Pojo.Register;
import com.wzx.Service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Mytest {
    @Test
    public void test(){
        Date date=new Timestamp(System.currentTimeMillis());
        System.out.println(date);
    }
    @Test
    public void test2 (){
        ApplicationContext applicationContext = null;
            String[] names = applicationContext.getBeanDefinitionNames();
            for (String name : names) {
                System.out.println(">>>>>>" + name);
            }
            System.out.println("------\nBean 总计:" + applicationContext.getBeanDefinitionCount());
        
    }
}
