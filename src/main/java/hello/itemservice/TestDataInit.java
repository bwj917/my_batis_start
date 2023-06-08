package hello.itemservice;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;

    /**
     * 확인용 초기 데이터 추가
     */
    //@EventListener 특정 이벤트일 경우에 처리하는 어노테이션
    // ApplicationReadyEvent.class 인자의 의미는 스프링빈이 모드 스프링컨테이너에 등록되고
    // 모든 의존관계가 주입된 후 발생하는 이벤트
    // @PostConstruct 어노테이션과 동일한 기능.
    // 차이점: @PostConstruct 자바표준에서 지원 @EventListener 스프링에서 지원
    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test data init");
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}
