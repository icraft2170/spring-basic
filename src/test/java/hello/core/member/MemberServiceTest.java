package hello.core.member;

import hello.core.config.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    ApplicationContext ac;
    MemberService memberService;

    @BeforeEach
    void setUp() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = ac.getBean("memberService", MemberService.class);
    }

    @Test
    void join() {
        //given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Member.Grade.VIP);

        //when
        memberService.joinMember(member);
        Member findMember = memberService.findMember(memberId);

        //then
        assertThat(member).isEqualTo(findMember);
    }

}
