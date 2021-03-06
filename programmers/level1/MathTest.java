

import java.util.*;
// Math.max로 여러개 값 중 최댓값 구하는 방법
// list를 int array로 변경하는 방법 (stream+intvalue)
// list를 string array로 바꾸는 두가지 방법. 1. stream.toArray(Sting[]::new) 2. list.toArray(new String[0]);
//        Arrays.stream(stringList.toArray(new String[0])).forEach(System.out::println);
//        Arrays.stream(stringList.stream().toArray(String[]::new)).forEach(System.out::println);
public class MathTest {
    // person 1 : 1 2 3 4 5 1 2 3 4 5 .. 로 찍음
    // person 2 : 2 1 2 3 2 4 2 5 2 1 .. 로 찍음
    // person 3 : 3 3 1 1 2 2 4 4 5 5 3 3 ..로 찍음
    // answer가 주어졌을 때 가능 맘ㄶ은 문제 맞힌 사람 누구인지 배열에 담아 return
    static int[] solution(int[] answers) {
        //그냥 for문으로 돈다.
//        int sum1 = 0;
//        int sum2 = 0;
//        int sum3 = 0;
        //다른풀이 : 위의 각 변수를 배열로 반들어 줄 수 있다.
        int[] sum = new int[3];
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) sum[0]++;
            if (answers[i] == person2[i % person2.length]) sum[1]++;
            if (answers[i] == person3[i % person3.length]) sum[2]++;
        }
        List<Integer> list = new ArrayList<>();
        int maxNum = max(sum[0],sum[1],sum[2]);
        if (maxNum == sum[0]) list.add(1);
        if (maxNum == sum[1]) list.add(2);
        if (maxNum == sum[2]) list.add(3);
//        Map<Integer,Integer> sum = new HashMap<>();
//        sum.put(1, sum1); sum.put(2, sum2);sum.put(3, sum3);
//        sum.forEach( (k,v)-> {
//            if(maxNum == v) list.add(k);
//        } );
       return list.stream().mapToInt(Integer::intValue).toArray();


    }
    static int max(int num1, int num2, int num3){
     return Math.max(Math.max(num1, num2), num3);
    }
    public static void main(String[] args) {
        int[] answer = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(answer)));

    }
}
