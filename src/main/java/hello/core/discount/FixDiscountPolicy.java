package hello.core.discount;

import hello.core.member.Member;

public class FixDiscountPolicy implements  DiscountPolicy{

    public static final int DISCOUNT_FIX_AMOUNT = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Member.Grade.VIP) {
            return DISCOUNT_FIX_AMOUNT;
        } else {
            return 0;
        }
    }
}
