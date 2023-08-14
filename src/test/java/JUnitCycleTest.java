import org.junit.jupiter.api.*;
public class JUnitCycleTest {
    // 전체 테스트를 시작하기 전에 1회 실행, 클래스 레벨 설정
    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    // 테스트 케이스를 시작하기 전마다 실행, 메서드 레벨 설정
    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    //메서드 레벨 정리
    @AfterAll
    static void afterAll(){
        System.out.println("@AfterAll");
    }

    //클래스 레벨 정리
    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach");
    }
}
