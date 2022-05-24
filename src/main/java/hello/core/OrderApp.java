package hello.core;

import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId, "hero", Member.Grade.VIP);
        memberService.joinMember(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("itemA = " + itemA);
        System.out.println("itemA.calculatorPrice() = " + itemA.calculatorPrice());
    }
}
