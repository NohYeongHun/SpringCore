package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("상태값을 가진 싱글톤 패턴의 문제점")
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A 사용자가 10000원 주문
        statefulService1.order("userA", 10000);
        // ThreadB : B 사용자가 20000원 주문
        statefulService2.order("userA", 20000);

        //ThreadA: 사용자 A 주문 금액 조회 => 10000원 이겠지?
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);
        // 서로 같은 객체를 참조하고 있으므로 price 값을 변환하면 10000원에서 -> 20000원으로 변경된다.
        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }

}