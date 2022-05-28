package hello.core.singleton;

import hello.core.config.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("싱글톤 없는 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 조회 1
        MemberService memberService1 = appConfig.memberService();
        // 조회 2
        MemberService memberService2 = appConfig.memberService();
        // 조회 1 과 2 참조값 비교
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너에서 제공하는 싱글톤 ")
    void singleContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 조회 1
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        // 조회 2
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        // 조회 1 과 2 참조값 비교
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
