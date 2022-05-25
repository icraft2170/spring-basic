package hello.core.discount;

import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 함.")
    void vip_o() {
        //given
        Member memberVIP = new Member(1L, "memberVIP", Member.Grade.VIP);
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        //when
        int discount = discountPolicy.discount(memberVIP, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할일 적용이 안됨")
    void vip_x() {
        //given
        Member memberBasic = new Member(2L, "memberBasic", Member.Grade.BASIC);
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        //when
        int discount = discountPolicy.discount(memberBasic, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}