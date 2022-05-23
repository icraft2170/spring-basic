package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

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
