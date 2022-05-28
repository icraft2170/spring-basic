package hello.core.beanfind;

import hello.core.config.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByNameAndType() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 구체 타입으로 조회")
    void findByImplType() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("없는 이름으로 빈 조회")
    void findByNameX() {
        Executable getBeanNameX = () -> ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, getBeanNameX);
    }

    @Test
    @DisplayName("같은 타입 2개 이상 있을 때 타입 조회할 때")
    void findByTypeDuplicate() {
        ApplicationContext testAc = new AnnotationConfigApplicationContext(TestConfig.class);
        Executable duplicateBeanType = () -> testAc.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class, duplicateBeanType);
    }

    @Test
    @DisplayName("같은 타입 2개 이상을 조회할 때 - 빈 이름 필수 ")
    void findByTypeDuplicateSuccess() {
        ApplicationContext testAc = new AnnotationConfigApplicationContext(TestConfig.class);
        MemberRepository memberRepository1 = testAc.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository1).isInstanceOf(MemoryMemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입 모두 조회")
    void findAllByType() {
        ApplicationContext testAc = new AnnotationConfigApplicationContext(TestConfig.class);
        Map<String, MemberRepository> beansOfType = testAc.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class TestConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

}
