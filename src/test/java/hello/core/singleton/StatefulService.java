package hello.core.singleton;

public class StatefulService {

    // private int price;
    // 무상태하게 설계하려면?
    // 예시
    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        return price; // 그냥 바로 값을 지역변수에서 반환하자.
    }

//    public int getPrice(){
//        return price;
//    }

}
