package hello.core.order;

import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

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