package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredOptionTest {

    @Test
    @DisplayName("required")
    void autoWiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        TestBean bean = ac.getBean(TestBean.class);

    }

    static class TestBean {

        // 해당되는 빈이 존재하지 않을 때는 호출되지 않음
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            // Member는 스프링 빈이 아니다.
            System.out.println("member = " + member);
        }

        // 호출은 되지만 member에 Null이 가능하다.
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member = " + member);
        }

        //
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            member.ifPresent(
                    (m) -> System.out.println("member = " + m)
            );
        }
    }

}
