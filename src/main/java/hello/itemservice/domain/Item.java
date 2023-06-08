package hello.itemservice.domain;

import lombok.Data;
/*
    도메인 클래스(Domain class): 비지니스 영역에서 사용되는 데이터를 나타내는 클래스
    비지니스 영역에서 처리하는 데이터를 나타내는 가장 기준이 되는 클래스
    따라서 도메인 클래스에서는 처리하는 데이터의 모든 필드(컬럼)이 표현되어야 한다.
    모든 필드를 저장하는 시나리오에서 Form 클래스의 역할을 할 수 있다.
    그리고 모든 필드를 insert하는 메소드에 대한 DTO 클래스의 역할을 할 수 있다.
    그런데 모든 필드를 insert하는 메소드에는 DTO 클래스를 별도로 만들지 않고
    일반적으로 도메인 클래스를 사용한다. 특별한 상황이 아니라면 From 클래스도 도메인 클래스로 작성 가능하다.
    Why? 도메인 클래스에는 처리하는 모든 필드(컬럼) 정보가 있다. 따라서
    DTO 클래스를 만드는 것은 중복 클래스를 만드는 것이기 때문이다.
 */
@Data
public class Item {

    private Long id;

    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
