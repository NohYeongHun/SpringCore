package hello.core;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
// ComponentScan 시 자동으로 AppConfig 등록되는 것을 막기위한 설정.
// 예제 코드를 제외하고 AutoAppConfig 설정을 하기 위함.
@ComponentScan(
        basePackages = "hello.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class))
public class AutoAppConfig {
}