package ir.dotin.registration.config;

import ir.dotin.registration.BasePackageMarker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication(scanBasePackageClasses = BasePackageMarker.class)
@Slf4j
@ComponentScan("ir.dotin.registration")
public class RegistrationConfig implements CommandLineRunner {

    private static final Logger LOG = getLogger(RegistrationConfig.class);

    @Override
    public void run(final String... args) throws Exception {
        LOG.info("Application initialized with arguments: {}", Arrays.toString(args));
    }

    @Bean
    public UserCreator userCreator() {
        return new UserCreator();
    }
}
