package practise_qsns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutations {
    public static void main(String[] args) {
        System.out.println("Enter the String to permute");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        List<String> results=stringPermutations(s);
        for(String i:results) {
            System.out.println(i);
        }

    }
    public static List<String> stringPermutations(String s) {
        List<String> results=new ArrayList<>();
        permute(results,"",s);
        return results;

    }

    static void  permute(List<String> list,String pref, String suff) {

        if(suff.length()==0) {
            list.add(pref);
        }
        else {
            for(int i=0;suff.length()>i;i++) {
                permute(list,pref+suff.charAt(i),suff.substring(0,i)+suff.substring(i+1));
            }
        }
    }
}
