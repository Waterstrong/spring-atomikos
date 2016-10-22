package ws.xa.atomikos.demo;

import java.io.Closeable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ws.xa.atomikos.demo.repository.AccountRepository;
import ws.xa.atomikos.demo.service.AccountService;

@SpringBootApplication
public class AtomikosApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication
                .run(AtomikosApplication.class, args);
        AccountService service = context.getBean(AccountService.class);
        AccountRepository repository = context.getBean(AccountRepository.class);
        service.createAccountAndNotify("josh");
        System.out.println("Count is " + repository.count());
        System.out.println("\n\n");
        try {
            service.createAccountAndNotify("error");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Check again: Count is " + repository.count());
        System.out.println("\n\n");
        Thread.sleep(100);
        ((Closeable) context).close();
    }

}
