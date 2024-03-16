import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        AtomicInteger sum = new AtomicInteger(0);

        int max = Integer.MIN_VALUE;

        executorService.submit(() -> {
            for (int number : numbers) {
                sum.addAndGet(number);
            }
        });

        executorService.submit(() -> {
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
        });

        executorService.shutdown();

        System.out.println("Tổng: " + sum.get());
        System.out.println("Phần tử lớn nhất: " + max);
    }
}
