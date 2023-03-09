import com.springframework.beans.factory.BeanFactory;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author G
 * @create 2023-03-09 6:36 PM
 */
public class SimpleBeanContainerTest {

    @Test
    public void  testGetBean() throws Exception{
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("HelloService",new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("HelloService");
        assertThat(helloService).isNotNull();
        assertThat(helloService.sayHello()).isEqualTo("Hello");
    }

    class HelloService{
        public String sayHello(){
            System.out.println("Hello");
            return "Hello";
        }
    }
}
