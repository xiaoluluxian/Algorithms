package Questions;

import java.util.*;


/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 */


public class MovingAverage {
    public static void main(String args[]){
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(5));
        System.out.println(m.next(3));

    }

    private int size = 0;
    private int index = 0;
    private double sum = 0;
    private Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size){
        this.size = size;
    }

    public double next(int val){
        double result = 0;
        if(queue.size()>=size){
            queue.poll();
            queue.offer(val);
            for(int num:queue){
                result+=num;
            }
        }
        else{
            queue.offer(val);
            for(int num:queue){
                result+=num;
            }
        }
        return result/queue.size();
    }
}
