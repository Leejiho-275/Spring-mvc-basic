package com.spring.mvc.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

// REST API를 만들기 위한 컨트롤러
@RestController
public class BasicController {

    // REST API를 요청할 시 html을 응답하지 않고 순수한 데이터(text, xml, json)를 리턴
    @GetMapping("/basic/text")
    public String text() {
        return "hello";
    }

    @GetMapping("/basic/list")
    public List<String> listStr() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        return list;
    }

    @GetMapping("/basic/car")
    public Car car() {
        Car car = new Car();
        car.setName("소나타");
        car.setCompany("현대");
        car.setGoods(Arrays.asList("우산", "물티슈", "상품권"));
        return car;
    }

    @GetMapping("/basic/person")
    public Person person() {
        Car car = new Car();
        car.setName("소나타");
        car.setCompany("현대");
        car.setGoods(Arrays.asList("우산", "물티슈", "상품권"));

        Person p = new Person();
        p.setName("김철수");
        p.setAge(35);
        p.setMyCar(car);

        return p;
    }

    @GetMapping("/basic/map")
    public Map<String, Person> personMap() {
        Map<String, Person> map = new HashMap<>();
        map.put("kim", new Person("김둘리", 20));
        map.put("park", new Person("박도우너", 15));
        map.put("lee", new Person("이희동", 5));

        return map;
    }
}
