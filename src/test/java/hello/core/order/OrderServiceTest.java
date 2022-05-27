package hello.core.order;

import hello.core.config.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {
    ApplicationContext ac;
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void setUp() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = ac.getBean("memberService", MemberService.class);
        orderService = ac.getBean("orderService", OrderService.class);
    }

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "hero", Member.Grade.VIP);
        memberService.joinMember(member);

        //when
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        //then
        assertThat(itemA.calculatorPrice()).isEqualTo(9000);
    }
}