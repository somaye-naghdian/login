package ir.dotin.registration.config;

import ir.dotin.registration.BasePackageMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = BasePackageMarker.class)
public class PersistenceJdbcAutoConfiguration {
}
