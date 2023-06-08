package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.memory.MemoryItemRepository;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * @Configuration 어노테이션은 스프링에서 Java 기반의 설정 클래스임을 나타내는 어노테이션입니다.
 * 이 어노테이션이 적용된 클래스는 스프링 컨테이너에 의해 빈(Bean)으로 관리되며, 스프링 애플리케이션의 구성(Configuration)을 정의하는 역할을 합니다.
 * @Configuration 어노테이션은 주로 @Bean 어노테이션과 함께 사용됩니다.
 * @Bean 어노테이션은 해당 메소드가 스프링 빈을 생성하여 컨테이너에 등록하도록 지정하는 역할을 합니다.
 * @Bean 어노테이션이 적용된 메소드의 반환 객체는 스프링 빈으로 관리되며, 이를 다른 빈에서 주입(Dependency Injection)하여 사용할 수 있습니다.
 * 이를 다른 빈에서 주입(Dependency Injection)하여 사용할 수 있습니다.
 * <정리> @Configuration - @Bean 어노테이션은 같이 사용하며
 * 메소드를 선택적으로 빈으로 등록하고자 할 때 사용한다.
 */
@Configuration
public class MemoryConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

}
