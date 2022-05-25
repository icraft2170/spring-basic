package hello.core.config;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService createMemberService() {
        return new MemberServiceImpl(createMemberRepository());
    }

    public OrderService createOrderService() {
        return new OrderServiceImpl(createMemberRepository(), createDisCountPolicy());
    }

    public DiscountPolicy createDisCountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberRepository createMemberRepository() {
        return new MemoryMemberRepository();
    }

}
