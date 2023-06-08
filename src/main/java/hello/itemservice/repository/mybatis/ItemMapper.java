package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

// @Mapper: MyBatis에서 인터페이스를 마이바티스 매퍼로 인식
// 인터페이스의 구현 메소드를 호출하면 매퍼 xml의 해당 SQL을 실행하고 결과를 돌려준다.
// 해당 XML의 mapper 태그의 namespace 속성에 Mapper 인터페이스를 지정해야한다.
// (구현체는 자동으로 생성된다.)
// xml의 위치는 src/main/resources 의 하위 폴더로 만든다.
@Mapper
public interface ItemMapper {

    void save(Item item);

    // MyBatis는 위치 기반으로 파마레터를 매핑하기 때문에 파라메터가 2개 이상일 떄에는 @Param을 지정해야 한다.
    // 2개 이상일 때 @Param 어노테이션을 지정하는 것은 스프링에서 명시적인 룰
    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);
//    void update(Long id, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearch);
}
