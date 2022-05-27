package hello.core;

import hello.core.config.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);


        Member hero = new Member(1L, "hero", Member.Grade.BASIC);
        memberService.joinMember(hero);

        Member findHero = memberService.findMember(1L);
        System.out.println("hero = " + hero.getName());
        System.out.println("findHero = " + findHero.getName());
    }
}
