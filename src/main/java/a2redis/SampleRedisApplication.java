package a2redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 11/24/17
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@SpringBootApplication
public class SampleRedisApplication implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate template;


    @Override
    public void run(String... strings) throws Exception {
        ValueOperations<String,String> ops = this.template.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.template.hasKey(key)) {
            ops.set(key,"foo");
        }
        System.out.println("Found key:" + key+ ",value:"+ops.get(key));
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleRedisApplication.class, args).close();
    }
}
