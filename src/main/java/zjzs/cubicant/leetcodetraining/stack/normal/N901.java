package zjzs.cubicant.leetcodetraining.stack.normal;

import java.util.ArrayList;
import java.util.List;

public class N901 {
    public static void main(String[] args) {
        N901 n901 = new N901();
        StockSpanner obj = n901.new StockSpanner();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 150000; ++i) {
            list.add(obj.next(10000));
        }
    }

    class StockSpanner {

        private List<Stock> list = new ArrayList<>();
        //record maxIndex to fast skip continue small number like such case (4,5,6,0,0,0,0,0,8)
        private int maxIndex;

        public StockSpanner() {

        }

        public int next(int price) {
            Stock stock = new Stock();
            int size = list.size();
            if (size == 0) {
                stock.span = 1;
            } else {
                if (price >= list.get(size - 1).price) {
                    int index = size - 1;
                    stock.span = 1;
                    if (price >= list.get(maxIndex).price) {
                        stock.span += index - maxIndex;
                        index = maxIndex;
                    }
                    do {
                        stock.span += list.get(index).span;
                        index -= list.get(index).span;
                    } while (index >= 0 && price >= list.get(index).price);
                    maxIndex = size;
                } else {
                    stock.span = 1;
                }
            }
            stock.price = price;
            list.add(stock);
            return stock.span;
        }

        private class Stock {
            int span;
            int price;
        }
    }
}
