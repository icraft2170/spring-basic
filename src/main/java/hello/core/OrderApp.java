package hello.core;

import hello.core.config.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "hero", Member.Grade.VIP);
        memberService.joinMember(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("itemA = " + itemA);
        System.out.println("itemA.calculatorPrice() = " + itemA.calculatorPrice());
    }
}
