package miniProject;

import java.util.Random;
import java.util.Scanner;

public class Coin {

    // 멤버 필드
    int coins;
    int priceOfCoin;
    Scanner sc = new Scanner(System.in);


    // 생성자 메서드 : 코인은 각각 10000개라고 가정. 가격은 랜덤.
    public Coin() {
        coins = 10000;
    }

    // 수시로 가격 변동 랜덤 메서드   # Controller class 활용
    public int randomprice() {
        Random random = new Random();
        priceOfCoin = random.nextInt(901) + 100;  // 100 <= 가격 <= 1000 랜덤
        return priceOfCoin;
    }
} // Coin class
