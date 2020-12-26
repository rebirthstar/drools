package com.slb.droolsdemo;




import com.slb.droolsdemo.entity.InsuredFact;
import com.slb.droolsdemo.entity.RuleInfoDTO;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

@SpringBootTest
public class DroolsdemoApplicationTests {

//    @Test
//    public void test1(){
//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
//        //会话对象，用于和规则引擎交互
//        KieSession kieSession = kieClasspathContainer.newKieSession();
//        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
////        Order order = new Order();
////        order.setOriginalPrice(210D);
//        Student student = new Student();
//        student.setAge(11);
//        Order order = new Order();
//        order.setRealPrice(10D);
//        //将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配
//        kieSession.insert(student);
//        kieSession.insert(order);
//        //激活规则引擎，如果规则匹配成功则执行规则
//        kieSession.fireAllRules();
//        //关闭会话
//        kieSession.dispose();
////        System.out.println("优惠前原始价格：" + order.getOriginalPrice() +
////                "，优惠后价格：" + order.getRealPrice());
//    }
//
//    @Test
//    public void test2(){
//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
//        //会话对象，用于和规则引擎交互
//        KieSession kieSession = kieClasspathContainer.newKieSession();
//        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
//        Student student1 = new Student();
//        student1.setAge(10);
//        Student student2 = new Student();
//        student2.setAge(10);
//        kieSession.insert(student1);
//        kieSession.insert(student2);
//        QueryResults query_1 = kieSession.getQueryResults("query_1", student1);
//        for (QueryResultsRow queryResultsRow : query_1) {
//            Student student = (Student)queryResultsRow.get("$s");
//            System.out.println(student);
//
//        }
//       // kieSession.fireAllRules();
//        //关闭会话
//        kieSession.dispose();
//    }
//
//    @Test
//    public void test3() throws IOException {
////        String url = "http://localhost:8080/kie-drools-wb/maven2/com/slb/drools/1.0.0/drools-1.0.0.jar";
////
////        KieServices kieServices = KieServices.Factory.get();
////        UrlResource resource = (UrlResource)kieServices.getResources().newUrlResource(url);
////        resource.setUsername("kie");
////        resource.setPassword("kie");
////        resource.setBasicAuthentication("enabled");
////        InputStream inputStream = resource.getInputStream();
////        KieRepository repository = kieServices.getRepository();
////        KieModule kieModule = repository.addKieModule(kieServices.getResources().newInputStreamResource(inputStream));
////        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
////        KieSession kieSession = kieContainer.newKieSession();
////        Person person = new Person();
////        person.setAge("1");
////        kieSession.insert(person);
////        kieSession.fireAllRules();
////        kieSession.dispose();
//    }
//
//
    @Test
    public void test4() throws IOException {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kContainer.newKieSession();
        List<RuleInfoDTO> ruleList = new ArrayList<>();
        RuleInfoDTO ruleInfoDTO = new RuleInfoDTO();
        kieSession.setGlobal("ruleList", ruleList);
        kieSession.setGlobal("ruleInfoDTO", ruleInfoDTO);
        InsuredFact insuredFact = new InsuredFact();
        insuredFact.setName("张三1");
        insuredFact.setHeight("180");
        insuredFact.setSex("2");
        insuredFact.setCardNo("2422");
        insuredFact.setBirthday(LocalDate.parse("2000-12-20"));
        insuredFact.setWeight("140");
        kieSession.insert(insuredFact);
        int i = kieSession.fireAllRules();
       System.out.println(i);

    }
//
//    @Test
//    public void test5Pool() throws IOException {
//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kContainer = kieServices.getKieClasspathContainer();
//        KieContainerSessionsPool kieContainerSessionsPool = kContainer.newKieSessionsPool(10);
//       // KieSession kieSession = kieContainerSessionsPool.newKieSession();
//        StatelessKieSession statelessKieSession = kieContainerSessionsPool.newStatelessKieSession();
//        String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};
//        Map<String, Room> name2room = new HashMap<String,Room>();
//        for( String name: names ){
//            Room room = new Room( name );
//            name2room.put( name, room );
//          // kieSession.insert( room );
//            Sprinkler sprinkler = new Sprinkler( room );
//            statelessKieSession.execute(Arrays.asList(new Object[] { room, sprinkler }));
//
//            //kieSession.insert( sprinkler );
//        }
//
//        //kieSession.fireAllRules();
////
////        Fire kitchenFire = new Fire( name2room.get( "kitchen" ) );
////        Fire officeFire = new Fire( name2room.get( "office" ) );
////        FactHandle kitchenFireHandle = kieSession.insert( kitchenFire );
////        FactHandle officeFireHandle = kieSession.insert( officeFire );
////        kieSession.fireAllRules();
////        kieSession.dispose();
//
//    }
//
//    @Test
//    public void test6() throws IOException {
//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kContainer = kieServices.getKieClasspathContainer();
//        KieSession kSession = kContainer.newKieSession("ksession-rule2");
//
//        Person p1 = new Person("Tom", 16);
//        Person p2 = new Person("Tom", 11);
//        IsChild isChild = new IsChild(p1);
//        IsChild isChild1 = new IsChild(p2);
//        FactHandle factHandle=kSession.insert(p1);
//        FactHandle factHandle2=kSession.insert(p2);
//        kSession.fireAllRules();
//
//        p1.setAge(25);
//        p2.setAge(25);
//        kSession.update(factHandle, p1,"age");
//        kSession.update(factHandle2, p2,"age");
//        //kSession.fireAllRules();
//       // kSession.dispose();
//    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.parse("2019-12-13");
        LocalDate end = LocalDate.parse("2022-01-14");
        long YEARS = ChronoUnit.YEARS.between(start, end);
        long MONTHS = ChronoUnit.MONTHS.between(start, end);
        long DAYS = ChronoUnit.DAYS.between(start, end);
        Period between = Period.between(start, end);
        System.out.println(YEARS);
        System.out.println(MONTHS);
        System.out.println(DAYS);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
        BigDecimal bigDecimal1 = new BigDecimal("12.0");
        BigDecimal bigDecimal2 = new BigDecimal("10000.1");
        System.out.println(bigDecimal1.pow(2));
        System.out.println(bigDecimal1.divide(bigDecimal2, RoundingMode.HALF_UP));
        System.out.println(new BigDecimal(53).divide(new BigDecimal(180).divide(new BigDecimal(100)).pow(2), RoundingMode.HALF_UP));
        boolean a =  new BigDecimal(50).divide(new BigDecimal(20).divide(new BigDecimal(100)).pow(2), RoundingMode.HALF_UP).compareTo(new BigDecimal(0)) == 1;
        System.out.println(a);
        System.out.println();
    }
}
