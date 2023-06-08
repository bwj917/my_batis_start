package hello.itemservice;

import hello.itemservice.config.MemoryConfig;
import hello.itemservice.config.MyBatisConfig;
import hello.itemservice.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
/*
@Import
@Configuration에서 지정한 단 하나의 설정 클래스에서 명시한 스프링빈으로 등록
인자에서 지정한 클래스는 기본 패키지 및 하위 패키지 경로이여도 무방하다.
 */
@Import(MyBatisConfig.class)
// 스프링 프로젝트를 구동하게 되면 컴포넌트 스캔 작업을 진행 => 스프링 컨테이너에 스프링빈으로 등록
// 컴포넌트 스캔은 어느 패키지에서? 기본 패키지 경로 및 기본 경로의 하위 패키지에서 한다.
// 기본 패키지 경로? Spring Initializr에서 지정한 경로
// scanBasePackages: 기본 컴포넌트 스캔 베이스 경로를 바꿀 경우에 사용
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItemserviceApplication.class, args);
	}

	@Bean
	// Profile은 빈을 선택적으로 등록하고 싶을 때 Profile명을 지정하여 사용
	// resourecs/application.properties 파일에 아래 설정을 하게 된다면
	// spring.profiles.active=local
	// profile이 local인 메소드에 대해서 선택적으로 빈을 생성한다.
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}
}
