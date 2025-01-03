//Hiwot Addis
//UGR/3763/14
package com.example.onlinebookstore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        TestLombok test = new TestLombok();
        test.setName("Hiwot Addis");
        test.setAge(20);
        System.out.println("Name: " + test.getName());
        System.out.println("Age: " + test.getAge());
    }
}
