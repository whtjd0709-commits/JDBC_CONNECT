package dbutil.test;

import java.util.Calendar;

import domain.orders.OrdersVO;
import repository.Orders;
import repository.OrdersDAOImpl;

public class RepositoryOrdersTest {

    private static Orders ordersRepo = new OrdersDAOImpl();

    public static void main(String[] args) {

        OrdersVO order = OrdersVO.builder()
            .orderList("볶음밥")
            .price(10000)
            .orderNum(1)
            .userId("testuser")
            .build();

        boolean result = insertTest(order);
        System.out.println("insert 결과 : " + result);

        //날짜 생성
        Calendar cal = Calendar.getInstance(); //calender 객체 생성
       //전달할 날짜문자 형식의 지정
    

        cal.set(2026,1,9,0,0,0);

    }

    public static boolean insertTest(OrdersVO order) {
        return ordersRepo.insertOrder(order);

    }
}
