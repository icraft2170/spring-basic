package hello.core.beanfind;

import hello.core.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("------------------------------------------");
            System.out.println("beanDefinitionName : " + beanDefinitionName);
            System.out.println("bean : " + bean);
            System.out.println("------------------------------------------");
        }
    }

    @Test
    @DisplayName("Application Bean 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                // 직접 추가한 빈
                System.out.println("----------------APPLICATION BEAN----------------");
                System.out.println("beanDefinitionName : " + beanDefinitionName);
                System.out.println("bean : " + bean);
                System.out.println("-------------------------------------------------");
            }
            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(beanDefinitionName);
                // 스프링 내부에서 사용하는 빈
                System.out.println("----------------INFRASTRUCTURE BEAN----------------");
                System.out.println("beanDefinitionName : " + beanDefinitionName);
                System.out.println("bean : " + bean);
                System.out.println("-------------------------------------------------");
            }

        }
    }
}
