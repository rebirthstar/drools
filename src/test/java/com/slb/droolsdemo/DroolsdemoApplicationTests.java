package com.slb.droolsdemo;


import com.slb.droolsdemo.entity.Order;
import com.slb.droolsdemo.entity.Student;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DroolsdemoApplicationTests {

    @Test
    public void test1(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        //会话对象，用于和规则引擎交互
        KieSession kieSession = kieClasspathContainer.newKieSession();
        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
//        Order order = new Order();
//        order.setOriginalPrice(210D);
        Student student = new Student();
        student.setAge(15);
        //将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配
        kieSession.insert(student);
        //激活规则引擎，如果规则匹配成功则执行规则
        kieSession.fireAllRules();
        //关闭会话
        kieSession.dispose();
//        System.out.println("优惠前原始价格：" + order.getOriginalPrice() +
//                "，优惠后价格：" + order.getRealPrice());
    }

    @Test
    public void test2(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        //会话对象，用于和规则引擎交互
        KieSession kieSession = kieClasspathContainer.newKieSession();
        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
        Student student1 = new Student();
        student1.setAge(10);
        Student student2 = new Student();
        student2.setAge(10);
        kieSession.insert(student1);
        kieSession.insert(student2);
        QueryResults query_1 = kieSession.getQueryResults("query_1", student1);
        for (QueryResultsRow queryResultsRow : query_1) {
            Student student = (Student)queryResultsRow.get("$s");
            System.out.println(student);

        }
       // kieSession.fireAllRules();
        //关闭会话
        kieSession.dispose();
    }
}
