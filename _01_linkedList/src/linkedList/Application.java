package linkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.linkedList
 * <p>fileName       : Application
 * <p>author         : hjsong
 * <p>date           : 2025-01-20
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-20        hjsong             최초 생성
 */
public class Application {
    public static void main(String[] args) {
        // 자바에서 제공하는 LinkedList 테스트
        List<String> list = new LinkedList<>();
        
        list.addFirst("사과");
        list.addFirst("딸기");

        System.out.println(list);
        System.out.println(list.size());
    }
}
