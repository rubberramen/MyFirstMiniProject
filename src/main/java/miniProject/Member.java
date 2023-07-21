package miniProject;

import java.util.Scanner;

public class Member {     // 한명의 회원 관리. 본 프로그램은 한명을 대상으로 함.

    // 멤버 필드
    String name;   // 회원 이름
    String accountNumber;  // 계좌번호
    int balance;      // 잔액
    int balanceStandard; // 수익률 계산을 위한 기준 잔액.

    Scanner sc = new Scanner(System.in);

    int sumBitcoin = 0;   // 회원이 소유한 누적 비트코인 갯수
    int sumEthereum = 0;   // 회원이 소유한 누적 이더리움 갯수
    int sumDogecoin = 0;   // 회원이 소유한 누적 도지코인 갯수


    // 생성자 메서드

    public Member(String name, String accountNumber, int balance) {    //Controller class에서 입력받을 예정
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.balanceStandard = balance;
    }

    // 입출금 기능 : Controller class에서 활용

    //입금 메서드
    public void inMoney() {
        System.out.print("입금 금액 : ");
        int money = sc.nextInt();

        balance += money;
        balanceStandard = balance;   // 수익률 계산을 위한 기준 잔액

        System.out.printf("잔액은 %d원 입니다.\n", balance);
    }

    //출금 메서드
    public void outMoney() {
        System.out.print("출금 금액 : ");
        int money = sc.nextInt();

        if(balance < money) {  // 잔액이 부족한 상황일 때
            System.out.println("잔액이 부족합니다.");
        }else {
            balance -= money;
            System.out.printf("잔액은 %d원 입니다.\n", balance);
        }
        balanceStandard = balance;   // 수익률 계산을 위한 기준 잔액
    }


    // 비트코인 매수
    public void buyBitcoin(Coin c, int amount) {

        int a = c.priceOfCoin * amount;  // a = 현시각 1개 가격 * 수량

        if(balance < a) {
            System.out.println("잔액이 부족합니다. 추가 입금을 해주세요.");
        }else {
            this.sumBitcoin += amount;   // 매수 : 비트코인 총 수량 (+)
            this.balance -= a;   // 잔액 - a
            System.out.printf("비트코인 %d개를 매수했습니다.\n", amount);
            System.out.printf("(%d개 * %d원 = %d원)\n",amount, c.priceOfCoin, a);

            System.out.printf("잔액 : %d원\n", this.balance);
            System.out.printf("소유 비트코인 수량 : %d개 ", sumBitcoin);
            System.out.println();
        }
    }

    // 비트코인 매도
    public void sellBitcoin(Coin c, int amount) {
        this.sumBitcoin -= amount;  // 매도 : 비트코인 총 수량 (-)

        int b = c.priceOfCoin * amount;  // b = 현시각 1개 가격 * 수량
        this.balance += b;  // 잔액 + b

        System.out.printf("비트코인 %d개를 매도했습니다.\n", amount);
        System.out.printf("(%d개 * %d원 = %d원)\n",amount, c.priceOfCoin, b);
        System.out.printf("잔액 : %d원\n", this.balance);
        System.out.printf("소유 비트코인 수량 : %d개\n", sumBitcoin);
    }

    // 이더리움 매수  # 비트코인과 논리 같음
    //부족한 점. 같은 메서드로 비트코인, 이더리움, 도지코인 할 수 있었다면.
    public void buyEthereum(Coin c, int amount) {
        int a = c.priceOfCoin * amount;

        if(balance < a) {
            System.out.println("잔액이 부족합니다. 추가 입금을 해주세요.");
        }else {
            this.sumEthereum += amount;
            this.balance -= a;
            System.out.printf("이더리움 %d개를 매수했습니다.\n", amount);
            System.out.printf("(%d개 * %d원 = %d원)\n",amount, c.priceOfCoin, a);
            System.out.printf("잔액 : %d원\n", this.balance);
            System.out.printf("소유 이더리움 수량 : %d개 ", sumEthereum);
            System.out.println();
        }
    }
    // 이더리움 매도   # 비트코인과 논리 같음
    //부족한 점. 같은 메서드로 비트코인, 이더리움, 도지코인 할 수 있었다면.
    public void sellEthereum(Coin c, int amount) {
        this.sumEthereum -= amount;

        int b = c.priceOfCoin * amount;
        this.balance += b;

        System.out.printf("이더리움 %d개를 매도했습니다.\n", amount);
        System.out.printf("(%d개 * %d원 = %d원)\n",amount, c.priceOfCoin, b);
        System.out.printf("잔액 : %d원\n", this.balance);
        System.out.printf("소유 이더리움 수량 : %d개\n", sumEthereum);
    }

    // 도지코인 매수   # 비트코인과 논리 같음
    //부족한 점. 같은 메서드로 비트코인, 이더리움, 도지코인 할 수 있었다면.
    public void buyDogecoin(Coin c, int amount) {
        int a = c.priceOfCoin * amount;

        if(balance < a) {
            System.out.println("잔액이 부족합니다. 추가 입금을 해주세요.");
        }else {
            this.sumDogecoin += amount;
            this.balance -= a;
            System.out.printf("도지코인 %d개를 매수했습니다.\n", amount);
            System.out.printf("(%d개 * %d원 = %d원)\n",amount, c.priceOfCoin, a);
            System.out.printf("잔액 : %d원\n", this.balance);
            System.out.printf("소유 도지코인 수량 : %d개 ", sumDogecoin);
            System.out.println();
        }
    }
    // 도지코인 매도  # 비트코인과 논리 같음
    //부족한 점. 같은 메서드로 비트코인, 이더리움, 도지코인 할 수 있었다면.
    public void sellDogecoin(Coin c, int amount) {
        this.sumDogecoin -= amount;

        int b = c.priceOfCoin * amount;
        this.balance += b;

        System.out.printf("도지코인 %d개를 매도했습니다.\n", amount);
        System.out.printf("(%d개 * %d원 = %d원)\n",amount, c.priceOfCoin, b);
        System.out.printf("잔액 : %d원\n", this.balance);
        System.out.printf("소유 도지코인 수량 : %d개\n", sumDogecoin);
    }

    // 투자 내역 보여주기
    public void show(Coin b, Coin e, Coin d) {

        // 총 보유 자산
        int total = this.balance + sumBitcoin * d.priceOfCoin + sumEthereum * e.priceOfCoin + sumDogecoin * d.priceOfCoin;

        System.out.printf("%s님, 총 보유자산 : %d원\n", name, total);

        // 평가손익
        System.out.printf("  - 평가손익 : %d원\n", total - balanceStandard);

        // 수익률
        System.out.printf("  - 수익률 : %5.2f%%\n", (double)(((total - balanceStandard) / (double)balanceStandard)*100));

        // 보유자산 포트폴리오
        System.out.println("보유자산 포트폴리오");
        System.out.printf("  - 원화 :%5.2f%%(%d원)\n", (double)((balance / (double)total) * 100), balance);
        System.out.printf("  - 비트코인 :%5.2f%%(%d원, %d개)\n", (double)(((sumBitcoin * d.priceOfCoin)/ (double)total) * 100), sumBitcoin * d.priceOfCoin, sumBitcoin);
        System.out.printf("  - 이더리움 :%5.2f%%(%d원, %d개)\n", (double)(((sumEthereum * e.priceOfCoin)/ (double)total) * 100), sumEthereum * e.priceOfCoin, sumEthereum);
        System.out.printf("  - 도지코인 :%5.2f%%(%d원, %d개)\n", (double)(((sumDogecoin * d.priceOfCoin)/ (double)total) * 100), sumDogecoin * d.priceOfCoin, sumDogecoin);

        // 부족한 점 : 각 코인의 평가손익, 수익률 표시했더라면.
    }

}  // Member class

