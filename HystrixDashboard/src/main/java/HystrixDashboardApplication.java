import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//开启服务监控注解
@EnableHystrixDashboard
//当前SpringBoot应用程序屏蔽数据库扫描（无需数据库）
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class HystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
