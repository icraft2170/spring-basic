package hello.core.discount;

import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{

    public static final int DISCOUNT_PERCENT = 10;

    @Override
    public int discount(Member member, int price) {
       if (member.getGrade() == Member.Grade.VIP) return (price * DISCOUNT_PERCENT) / 100;
       else return 0;
    }
}
