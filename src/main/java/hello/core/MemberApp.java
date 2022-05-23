package hello.core;

import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member hero = new Member(1L, "hero", Member.Grade.BASIC);

        memberService.joinMember(hero);

        Member findHero = memberService.findMember(1L);
        System.out.println("hero = " + hero.getName());
        System.out.println("findHero = " + findHero.getName());
    }
}
