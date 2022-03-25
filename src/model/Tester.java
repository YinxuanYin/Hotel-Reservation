package model;

import static model.RoomType.SINGLE;

/* To test the Code
   Illegal Argument Expression  should be thrown if input email doesn't match regular expression
 */
public class Tester {
    public static void main(String[] args){
        Customer customer = new Customer("Yinxuan ","Yin ","yzy5430@com");
        System.out.println(customer);
    }
}
