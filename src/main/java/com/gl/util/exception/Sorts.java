package com.gl.util.exception;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: 山毛榉
 * @date : 2022/9/9 16:23
 * @version: 1.0
 * @description:none
 */
public class Sorts {

    /**
     * group by 分组  根据性别 分组 统计年龄
     */
    @Test
    public void test(){

        List<Student> list =new ArrayList<>();
        list.add(new Student(12,"男","scott"));
        list.add(new Student(22,"女","lily"));
        list.add(new Student(15,"女","emily"));
        list.add(new Student(32,"男","tiger"));
        Map<String, Integer> collect = list.stream().collect(Collectors.groupingBy(Student::getSex,Collectors.summingInt(Student::getAge)));


        System.out.println("collect = " + collect);
    }
}
