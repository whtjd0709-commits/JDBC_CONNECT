package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dbutil.test.DBUtil;
import domain.orders.OrdersVO;

public class OrdersDAOImpl implements Orders {

    // 주문 삭제
    @Override
    public boolean deleteOrder(long id) {
        boolean result = false;
        String sql = "delete from orders where id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            if (pstmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("DB 연동 실패 : " + e.getMessage());
        }

        return result;
    }

    // 주문 추가
    @Override
    public boolean insertOrder(OrdersVO order) {
        boolean result = false;
        String sql = "insert into orders (orderList, orderNum, price, userId) values (?,?,?,?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, order.getOrderList());
            pstmt.setInt(2, order.getOrdernum());
            pstmt.setInt(3, order.getPrice());
            pstmt.setString(4, order.getUserId());

            if (pstmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("DB 연동 실패 : " + e.getMessage());
        }

        return result;
    }

    // 주문 수정
    @Override
    public boolean modifyOrder(OrdersVO order) {
        boolean result = false;
        String sql = "update orders set orderList=?, orderNum=?, price=?, date=? where id=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, order.getOrderList());
            pstmt.setInt(2, order.getOrdernum());
            pstmt.setInt(3, order.getPrice());
            pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            pstmt.setLong(5, order.getId());

            if (pstmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("DB 연동 실패 : " + e.getMessage());
        }

        return result;
    }

    // 전체 주문 목록
    @Override
    public List<OrdersVO> ordersList() {
        List<OrdersVO> list = new ArrayList<>();
        String sql = "select * from orders";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                list.add(
                    OrdersVO.builder()
                        .id(rs.getLong("id"))
                        .orderList(rs.getString("orderList"))
                        .ordernum(rs.getInt("orderNum"))
                        .price(rs.getInt("price"))
                        .date(rs.getTimestamp("date"))
                        .userId(rs.getString("userId"))
                        .build()
                );
            }

        } catch (Exception e) {
            System.out.println("DB 연동 실패 : " + e.getMessage());
        }

        return list;
    }

    // 주문번호로 검색 (단건)
    @Override
    public Optional<OrdersVO> ordersSearch(long orderNum) {
        Optional<OrdersVO> order = Optional.empty();
        String sql = "select * from orders where orderNum = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, orderNum);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                order = Optional.of(
                    OrdersVO.builder()
                        .id(rs.getLong("id"))
                        .orderList(rs.getString("orderList"))
                        .ordernum(rs.getInt("orderNum"))
                        .price(rs.getInt("price"))
                        .date(rs.getTimestamp("date"))
                        .userId(rs.getString("userId"))
                        .build()
                );
            }

        } catch (Exception e) {
            System.out.println("DB 연동 실패 : " + e.getMessage());
        }

        return order;
    }

    // 사용자 ID로 주문 검색 (여러 건)
    @Override
    public List<OrdersVO> ordersSearch(String userId) {
        List<OrdersVO> list = new ArrayList<>();
        String sql = "select * from orders where userId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(
                    OrdersVO.builder()
                        .id(rs.getLong("id"))
                        .orderList(rs.getString("orderList"))
                        .ordernum(rs.getInt("orderNum"))
                        .price(rs.getInt("price"))
                        .date(rs.getTimestamp("date"))
                        .userId(rs.getString("userId"))
                        .build()
                );
            }

        } catch (Exception e) {
            System.out.println("DB 연동 실패 : " + e.getMessage());
        }

        return list;
    }

    // 날짜로 주문 검색
    @Override
    public List<OrdersVO> ordersSearchDate(String date) {
        List<OrdersVO> list = new ArrayList<>();
        String sql = "select * from orders where date(date) = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, date);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(
                    OrdersVO.builder()
                        .id(rs.getLong("id"))
                        .orderList(rs.getString("orderList"))
                        .ordernum(rs.getInt("orderNum"))
                        .price(rs.getInt("price"))
                        .date(rs.getTimestamp("date"))
                        .userId(rs.getString("userId"))
                        .build()
                );
            }

        } catch (Exception e) {
            System.out.println("DB 연동 실패 : " + e.getMessage());
        }

        return list;
    }
}
