package org.example.TestLambda;

import java.util.List;
import java.util.function.*;

/**
 * @Comsumer  有参，无返回值
 * @Function  有参，有返回值
 * @Predicate 有参，返回boolean
 * @Supplier  有参，有返回值
 * @Operator  有参，有返回值，且类型一致
 *
 * @前缀           含义
 * @Unary         一元
 * @Binary        二元
 * @Ternary       三元
 * @Quatenary     四元
 */
public class TestLamdaAPI {
    record Student(String name, int age) {
        boolean nbtage() {
            return this.age >= 18;
        }
    }

    /**
     * 将下面代码块改写为lambda形式
     * @param predicate
     * 传入参数时，分别用
     *
     * * 类名::静态方法名
     * * 类名::非静态方法名
     *
     * 来表示【学生年龄大于等于18】的条件
     */
    static void highOrder(Predicate<Student> predicate) {
        List<Student> students = List.of(
                new Student("zs", 19),
                new Student("ls", 15),
                new Student("wg", 20)
        );
        for(Student student : students) {
            if (predicate.test(student)) {
                System.out.println(student);
            }
        }
    }

    static boolean btege(Student student) {
        return student.age >= 18;
    }



    public static void main(String[] args) {
        //筛选出年龄大于18
        highOrder(student -> student.age > 18);
        System.out.println("--------------------------");
        //类名加静态方法名
        highOrder(TestLamdaAPI::btege);
        System.out.println("--------------------------");
        //类名加非静态
        highOrder(Student::nbtage);
    }
}
