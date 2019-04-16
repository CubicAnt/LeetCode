package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.Arrays;
import java.util.LinkedList;

public class N853 {
    public static void main(String[] args) {
        LeetCodeUtil.execute(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3});
    }

    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            if (position.length == 0) {
                return 0;
            }

            Car[] cars = new Car[position.length];
            for (int i = 0; i < position.length; ++i) {
                cars[i] = new Car(position[i], speed[i]);
            }
            Arrays.sort(cars, (car1, car2) -> car1.position - car2.position);

            LinkedList<Car> stack = new LinkedList<>();
            stack.push(cars[0]);
            Car top;
            for (int i = 1; i < position.length; ++i) {
                if (stack.peek().slower(cars[i], target)) {
                    stack.push(cars[i]);
                }
            }

            return stack.size();
        }

        private class Car {
            int position;
            int speed;
            Car(int position, int speed) {
                this.position = position;
                this.speed = speed;
            }

            boolean slower(Car car, int target) {
                if (car.speed >= speed) {
                    return true;
                } else {
                    return (long)((car.position - position) * car.speed) > (long)((target - car.position) * (speed - car.speed));
                }
            }
        }
    }
}
